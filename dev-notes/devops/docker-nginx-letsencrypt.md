# Certbot y nginx

> Gestionar certificados con Certbot y Docker

Crear el archivo docker-compose.yml con los servicios de nginx y cerbot

```dockerfile
version: '3'
services:
  nginx:
    image: nginx:1.15-alpine
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - ./data/nginx:/etc/nginx/conf.d
      - ./data/certbot/conf:/etc/letsencrypt
			- ./data/certbot/www:/var/www/certbot
		command: "/bin/sh -c 'while :; do sleep 6h & wait $${!}; nginx -s reload; done & nginx -g \"daemon off;\"'"
  certbot:
    image: certbot/certbot
    volumes:
	  	- ./data/certbot/conf:/etc/letsencrypt
  		- ./data/certbot/www:/var/www/certbot
  	entrypoint: "/bin/sh -c 'trap exit TERM; while :; do certbot renew; sleep 12h & wait $${!}; done;'"
```

Crear la configuracion de nginx en la carpeta **data/nginx**

```
server {
    listen 80;
    server_name example.org;
    location /.well-known/acme-challenge/ {
    		root /var/www/certbot;
		}
    location / {
        return 301 https://$host$request_uri;
    }    
}
server {
    listen 443 ssl;
    server_name example.org;
    ssl_certificate /etc/letsencrypt/live/example.org/fullchain.pem;
		ssl_certificate_key /etc/letsencrypt/live/example.org/privkey.pem;
		include /etc/letsencrypt/options-ssl-nginx.conf;
		ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem;
    location / {
        proxy_pass http://example.org; #for demo purposes
    }
}
```

Enlazando a nginx y certbot

```bash
$ curl -L https://raw.githubusercontent.com/wmnnd/nginx-certbot/master/init-letsencrypt.sh > init-letsencrypt.sh
$ chmod +x init-letsencrypt.sh  
$ sudo ./init-letsencrypt.sh
```

Iniciando los servicios

```bash
$ docker-compose up
```

Referencia:

- https://medium.com/@pentacent/nginx-and-lets-encrypt-with-docker-in-less-than-5-minutes-b4b8a60d3a71
- https://github.com/wmnnd/nginx-certbot
- https://raw.githubusercontent.com/wmnnd/nginx-certbot/master/init-letsencrypt.sh