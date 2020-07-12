# Instalar Laravel con Docker

Descargar Laravel

```bash
$ git clone https://github.com/laravel/laravel.git laravel-app
$ cd laravel-app
```

Usar una imagen de composer para crear un contenedor temporal

```bash
$ docker run --rm -v $(pwd):/app composer install
$ sudo chown -R $USER:$USER ~/laravel-app
```

Crear el archivo docker-compose

`$ vim laravel-app/docker-compose.yml`

Se deben crear 3 servicios: app, servidor web y base de datos

```dockerfile
version: '3'
services:
  #PHP
  app:
    build:
      context: .
      dockerfile: Dockerfile
    image: mi-app-laravel
    container_name: app
    restart: unless-stopped
    tty: true
    environment:
      SERVICE_NAME: app
      SERVICE_TAGS: dev
    working_dir: /var/www
    volumes:
      - ./:/var/www
      - ./php/local.ini:/usr/local/etc/php/conf.d/local.ini
    networks:
      - app-network

  #Nginx
  webserver:
    image: nginx:alpine
    container_name: webserver
    restart: unless-stopped
    tty: true
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - ./:/var/www
      - ./nginx/conf.d/:/etc/nginx/conf.d/
    networks:
      - app-network

  #MySQL
  db:
    image: mysql:5.7.22
    container_name: db
    restart: unless-stopped
    tty: true
    ports:
      - "3306:3306"
    environment:
      MYSQL_DATABASE: ${MYSQL_DATABASE}
      MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
      SERVICE_TAGS: ${SERVICE_TAGS}
      SERVICE_NAME: ${SERVICE_NAME}
    volumes:
      - dbdata:/var/lib/mysql/
      - ./mysql/my.cnf:/etc/mysql/my.cnf
    networks:
      - app-network

#Redes
networks:
  app-network:
    driver: bridge
#Volumenes
volumes:
  dbdata:
    driver: local
```

Crear un archivo .env para la configuración del docker-compose y de laravel

```bash
MYSQL_DATABASE=laravel
MYSQL_ROOT_PASSWORD=el_password_root
SERVICE_TAGS=dev
SERVICE_NAME=mysql
DB_CONNECTION=mysql
DB_HOST=db
DB_PORT=3306
DB_DATABASE=laravel
DB_USERNAME=usuario_laravel
DB_PASSWORD=el_password_de_la_app
```

Crear el archivo Dockerfile

```dockerfile
FROM php:7.2-fpm

# Copiar composer.lock y composer.json
COPY composer.lock composer.json /var/www/

# Configura el directorio raiz
WORKDIR /var/www

# Instalamos dependencias
RUN apt-get update && apt-get install -y \
    build-essential \
    mysql-client \
    libpng-dev \
    libjpeg62-turbo-dev \
    libfreetype6-dev \
    locales \
    zip \
    jpegoptim optipng pngquant gifsicle \
    vim \
    unzip \
    git \
    curl

# Borramos cache
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

# Instalamos extensiones
RUN docker-php-ext-install pdo_mysql mbstring zip exif pcntl
RUN docker-php-ext-configure gd --with-gd --with-freetype-dir=/usr/include/ --with-jpeg-dir=/usr/include/ --with-png-dir=/usr/include/
RUN docker-php-ext-install gd

# Instalar composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# agregar usuario para la aplicación laravel
RUN groupadd -g 1000 www
RUN useradd -u 1000 -ms /bin/bash -g www www

# Copiar el directorio existente a /var/www
COPY . /var/www

# copiar los permisos del directorio de la aplicación
COPY --chown=www:www . /var/www

# cambiar el usuario actual por www
USER www

# exponer el puerto 9000 e iniciar php-fpm server
EXPOSE 9000
CMD ["php-fpm"]
```

Configurar PHP

```bash
$ mkdir laravel-app/php
$ vim laravel-app/php/local.ini

# Contenido del archivo local.ini
upload_max_filesize=100M
post_max_size=100M
```

Configurar Nginx

```bash
$ mkdir -p laravel-app/nginx/conf.d
$ vim laravel-app/nginx/conf.d/app.conf

# Contenido del archivo app.conf
server {
    listen 80;
    index index.php index.html;
    error_log  /var/log/nginx/error.log;
    access_log /var/log/nginx/access.log;
    root /var/www/public;
    location ~ \.php$ {
        try_files $uri =404;
        fastcgi_split_path_info ^(.+\.php)(/.+)$;
        fastcgi_pass app:9000;
        fastcgi_index index.php;
        include fastcgi_params;
        fastcgi_param SCRIPT_FILENAME $document_root$fastcgi_script_name;
        fastcgi_param PATH_INFO $fastcgi_path_info;
    }
    location / {
        try_files $uri $uri/ /index.php?$query_string;
        gzip_static on;
    }
}
```

Configurar MySQL

```bash
$ mkdir laravel-app/mysql
$ vim laravel-app/mysql/my.cnf

# Contenido del archivo my.cnf
[mysqld]
general_log = 1
general_log_file = /var/lib/mysql/general.log
```

Ejecurar el entorno

```bash
$ docker-compose up -d
$ docker -ps

# Si todo fue bien se deben mostrar los contenedores en ejecución
CONTAINER ID        NAMES               IMAGE                             STATUS              PORTS
c31b7b3251e0        db                  mysql:5.7.22                      Up 2 seconds        0.0.0.0:3306->3306/tcp
ed5a69704580        app                 mi-app-laravel                    Up 2 seconds        9000/tcp
5ce4ee31d7c0        webserver           nginx:alpine                      Up 2 seconds        0.0.0.0:80->80/tcp, 0.0.0.0:443->443/tcp

# Para mejorar la seguridad de la aplicación
$ docker-compose exec app php artisan key:generate
$ docker-compose exec app php artisan config:cache
```

## Migrar la base de datos

Primero ejecutamos el contenedor de la base de datos MySQL

`$ docker-compose exec db bash` o `$docker-compose exec db sh`

```bash
$ mysql -u root -p <PASSWORD>
$ mysql> show databases;
$ mysql> GRANT ALL ON laravel.* TO 'usuario_laravel'@'%' IDENTIFIED BY 'su_password_de_la_base_de_datos';
$ mysql> FLUSH PRIVILEGES;
$ mysql> EXIT;
```

`$ docker-compose exec app php artisan migrate`

`$ docker-compose exec app php artisan tinker`

```php
>>> \DB::table('migrations')->get();

/*Output*/
Illuminate\Support\Collection {#2856
     all: [
       {#2862
         +"id": 1,
         +"migration": "2014_10_12_000000_create_users_table",
         +"batch": 1,
       },
       {#2865
         +"id": 2,
         +"migration": "2014_10_12_100000_create_password_resets_table",
         +"batch": 1,
       },
     ],
   }
```
