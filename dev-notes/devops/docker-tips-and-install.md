# Instalación de Docker

Lo primero es necesario actualizar el repositorio de paquetes de Ubuntu

`$ sudo apt update && sudo apt upgrade`

> Si falla la conexión con el servidor antes de que se actualicen los paquetes, el servicio de paquetes apt mostrará el
> siguiente error: `Could not get lock /var/lib/dpkg/lock`, para corregirlo debemos cerrar los procesos de apt. Primero
> es necesario ejecutar el siguiente comando `$ ps aux | grep -i apt` y matar el proceso con la siguiente instrucción
> `$ sudo kill -9 {id del proceso}` o simplemente ejecuta `$ sudo killall apt apt-get`, por último es necesario realizar
> una limpieza de la instalación fallida con el siguiente comando `$ sudo dpkg --configure -a`

Una vez actualizada la versión de ubuntu lo recomendable es limpiar el espacio de los paquetes que ya no son necesarios:

`$ sudo apt-get autoclean && sudo apt-get clean && sudo apt-get autoremove`

Para la instalación de Docker, es necesario de eliminar posibles instalaciones anteriores

`$ sudo apt remove docker docker-engine docker.io`

Ahora, es necesario instalar paquetes necesarios

`$ sudo apt install apt-transport-https ca-certificates curl software-properties-common gnupg`

Establecer la llave GPG

`$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -`

Verificar la huella GPG

`$ sudo apt-key fingerprint 0EBFCD88`

Agregar el repositorio

`$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"`

> En el caso de docker-ce se puede presentar un error donde el paquete de instalación stable no este disponible,
> si este fuera el caso solo es necesario usar una version de tipo edge o test:
> `sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable edge test"`

Después, es necesario actualizar los paquetes

```bash
$ sudo apt update
$ apt-cache policy docker-ce
$ sudo apt install -y docker-ce
```

Limitar el acceso de docker con un usuario

`$ sudo usermod -aG docker ${USER}`

Ingresar con el usuario creado

`$ su - ${USER}`

Verificar el grupo donde se agregó al usuario

`$ id -nG`

Registrar usuarios al grupo de docker

`$ sudo usermod -aG docker username`

Verificar la instalación de docker

`$ docker run hello-world`

Iniciar y habilitar Docker

```bash
$ systemctl status docker
$ systemctl start docker
$ systemctl enable docker
```

## Instalar docker compose

Verificar la ultima version de docker compose, en este ejemplo es la 1.25.5:

`$ sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose`

Asignar los permisos de ejecución

`$ sudo chmod +x /usr/local/bin/docker-compose && sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose`

Verificar la instalación

`$ docker-compose --version`

## Activar funciones experimentales

```bash
$ sudo vim /etc/docker/daemon.json
```

Agregar el siguiente contenido al archivo _daemon.json_

```json
{
  "experimental": true
}
```

Reiniciar el servicio de docker

```bash
$ sudo service docker restart
```

Verificar la activación de las funciones experimentales

```bash
$ docker version
```

Se debe ver lo siguiente `Experimental: true`

## Descargar archivos de un repositorio privado

> Se necesita crear un Token para acceder a los repositorios privados
>
> Tambien se requiere la aplicacion jq, para extraer la informacion del API de GitHub

```bash
#!/usr/bin/env bash
set -e

GITHUB_TOKEN=<my_token>
REPO="lgzarturo/demo"
FILE="release.tar.gz"
VERSION="v0.0.1"

wget -q --auth-no-challenge --header='Accept:application/octet-stream' \
	https://$GITHUB_TOKEN:@api.github.com/repos/$REPO/releases/assets/`curl -H "Authorization: token $GITHUB_TOKEN" -H "Accept: application/vnd.github.v3.raw"  -s https://api.github.com/repos/$REPO/releases | jq ". | map(select(.tag_name == \"$VERSION\"))[0].assets | map(select(.name == \"$FILE\"))[0].id"` \
  -O /tmp/$FILE
```

## Acceder a un repositorio privado con Docker

### Via Token para GitHub

> [Enlace para crear un token](https://github.com/settings/tokens)

```do
FROM ubuntu as intermediate
RUN apt-get update
RUN apt-get install -y git

RUN git config --global url."https://{token}:@github.com/".insteadOf "https://github.com/"
RUN echo -e "StrictHostKeyChecking no" > /root/.ssh/config
RUN git clone git@{bitbucket.org|github.com|gitlab.com}:{user}/{repo}.git
RUN rm /root/.ssh/id_rsa

FROM ubuntu
COPY --from=intermediate /{repo} /srv/{repo}
```

### Via SSH

```dockerfile
FROM ubuntu as intermediate
RUN apt-get update
RUN apt-get install -y git

# pasar por parametro la llave publica o copiarla al docker
ARG SSH_PRIVATE_KEY
RUN mkdir -p /root/.ssh/
RUN echo "${SSH_PRIVATE_KEY}" > /root/.ssh/id_rsa
RUN chmod 600 /root/.ssh/id_rsa
RUN touch /root/.ssh/known_hosts
RUN ssh-keyscan {bitbucket.org|github.com|gitlab.com} >> /root/.ssh/known_hosts
RUN echo -e "[url \"git@{bitbucket.org|github.com|gitlab.com}:\"]\n\tinsteadOf = https://github.com/" >> /root/.gitconfig
RUN echo -e "StrictHostKeyChecking no" > /root/.ssh/config
RUN git clone git@{bitbucket.org|github.com|gitlab.com}:{user}/{repo}.git
RUN rm /root/.ssh/id_rsa

FROM ubuntu
COPY --from=intermediate /{repo} /srv/{repo}

```

> Ejecutar el dockerfile con el parametro `—squash` para reducir el tamaño de las imágenes y remover archivos que no son necesarios, para esto hay que activar las caracteristicas experimentales de docker.
>
> `$ docker build --squash […]`

## Multi-stage build

Ejemplo para crear imagenes con docker de tipo multi-stage. El objetivo es obtener imagenes mas pequeñas con capas intermedias que puedan ser borradas.

```dockerfile
FROM ubuntu as intermediate
LABEL stage=intermediate
ARG SSH_PRIVATE_KEY
WORKDIR /root/temp
RUN apt-get update && apt-get install -y git npm
RUN mkdir /root/.ssh/
RUN echo "${SSH_PRIVATE_KEY}" > /root/.ssh/id_rsa
RUN chmod 600 /root/.ssh/id_rsa
RUN touch /root/.ssh/known_hosts
RUN ssh-keyscan github.com >> /root/.ssh/known_hosts
COPY package*.json ./
RUN npm install
RUN cp -R node_modules prod_node_modules

FROM node:10 as release
RUN mkdir -p /usr/src/api
WORKDIR /usr/src/api
COPY package*.json ./
RUN npm install
COPY . .
COPY --from=intermediate /root/temp/prod_node_modules ./node_modules
EXPOSE 3002
CMD ["node", "./bin/www"]
```

> Para elminiar las imagenes intermedias solo es necesario ejecutar el siguiente comando:
>
> `$ docker rmi -f $(docker images -q --filter label=stage=intermediate)`

## Comandos de docker

### Recrear una imagen

Para recrear una imagen de Docker sin tomar en cuenta el cache solo hay que usar el parametro `--no-cache`

`$ docker-compose build --no-cache <service>`

### Iniciar una imagen

Reiniciar una imagen en background de un servicio

`$ docker-compose up -d <service>`

### Acceder al log de un contenedor

`$ docker container logs <container_name>`

- [Docker](https://devopswithdocker.com/part3/)
- [How does docker port binding work](https://medium.com/better-programming/how-does-docker-port-binding-work-b089f23ca4c8)
- [Docker tutorial with Nginx](https://www.digitalocean.com/community/tutorials/docker-explained-how-to-containerize-and-use-nginx-as-a-proxy)
- [Tomcat 8.5 AJP](http://tomcat.apache.org/tomcat-8.5-doc/config/ajp.html)
- [Tomcat Docker](https://github.com/Unidata/tomcat-docker/blob/master/server.xml)
- [APSL Docker Tomcat](https://github.com/APSL/docker-tomcat/blob/master/j5t5/conf/server.xml.tpl)
