# Encriptar con OpenSSL

Encriptar archivos y carpetas con openssl

`$ tar -czf - * | openssl enc -e -aes256 -out secured.tar.gz`

`$ tar cz my_folder/ | openssl enc -e -aes-256-cbc > encrypted.tar.gz.enc`

```bash
$ tar -C grails-config -czv {FOLDER} | openssl enc -pbkdf2 -e -pass pass:{PASSWORD} > {FOLDER}.tar.gz.enc

$ tar -C target -czvf - {FILE} | openssl enc -pbkdf2 -e -pass pass:{PASSWORD} > {FILE}.tar.gz.enc

```

Comando para desencriptar

`$ openssl enc -d -aes256 -in secured.tar.gz | tar xz -C test`

`$ openssl enc -d aes-256-cbc -in encrypted.tar.gz.enc | tar xz`

```bash
$ openssl enc -pbkdf2 -pass pass:{PASSWORD} -d -in {FOLDER}.tar.gz.enc | tar xz

$ openssl enc -pbkdf2 -pass pass:{PASSWORD} -d -in {FILE}.war.tar.gz.enc | tar xz
```

## Borrar el último comando ejecutado en la terminal (linux)

```bash
$ history -d $(expr $(history | tail -n 1 | grep -oP '^ \d+') - 1);
$ for offset in $(history | awk '/backup-files/ {print $1}' | tac); do :; history -d $offset; done
$ history | grep 'backup-files' | grep -oP '^ \d+' | head -1
$ history | tail -n 1 | grep 'backup-files' | grep -oP '^ \d+'
```

