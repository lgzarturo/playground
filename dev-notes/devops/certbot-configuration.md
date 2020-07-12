# Configuración de Certbot

## Instalar el repositorio de Certbot

El objetivo es gestionar certificados de seguridad con Let's Encrypt, con Certbot se puede automatizar la instalacion y la renovación de certificados de seguridad con nginx.

`$ sudo add-apt-repository ppa:certbot/certbot`

### Actualizar los repositorios de paquetes del sistema

`$ sudo apt-get update`

### Instalar Certbot

`$ sudo apt-get install python-certbot-nginx`

### Configurar los dominios

Editar la configuración de Nginx con los dominios que se requieren proteger

`$ vim /etc/nginx/sites-available/{filename}`

> `server_name {dominio.com} www.{dominio.com};`

### Verificar la configuración de Nginx antes de reiniciar el servicio

`$ sudo nginx -t`

### Reiniciar el servicio de Nginx

`$ sudo systemctl reload nginx`

### Verificar la configuración del firewall

```bash
$ sudo ufw status
$ sudo ufw allow 'Nginx Full'
$ sudo ufw delete allow 'Nginx HTTP'
$ sudo ufw status
```

### Instalar el certificado en los dominios

`$ sudo certbot --nginx -d {dominio.com} -d www.{dominio.com}`

### Verificar la renovación automática cada 3 meses del certificado

`$ sudo certbot renew --dry-run`
