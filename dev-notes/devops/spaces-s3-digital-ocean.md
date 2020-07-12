# Usar S3 Spaces desde la terminal

Primero es necesario tener instalado el paquete s3cmd para gestionar desde la linea de comando los archivos del bucket de spaces en Digital Ocean.

Lo primero es ejecutar el siguiente comando en una terminal de Ubuntu.

```bash
$ sudo apt-get install -y s3cmd
```

Ahora, es necesario configurar la herramienta, con el siguiente comando:

```bash
$ s3cmd --configure
```

El sistema nos solicita los datos que te autentican como usuario.

- Access key
- Secret key
- Default region
- S3 endpoint
- DNS style
- Password
- GPG
- Http connectivity
- Proxy server

Una vez que se proporcionan los datos requeridos, el sistema debe realizar una prueba para verificar la configuracoin asociada.

Por último el sistema solicita una confirmación para guardar la información.
