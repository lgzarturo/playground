# Notas sobre MySQL

## Crear una base de datos

Lo recomendable es crear un base de datos con soporte UTF-8

`$ create {DATABASE} character set UTF8 collate utf8_bin;`

## Respaldo con Docker

Generando un backup desde un contenedor

`$ docker exec CONTAINER /usr/bin/mysqldump -u root --password={PASSWORD} {DATABASE} > backup.sql`

Restaurar un respaldo de la base de datos

`$ cat backup.sql | docker exec -i CONTAINER /usr/bin/mysql -u root --password={PASSWORD} {DATABASE}`

## Consultas

### Remplazar texto de un campo

```mysql
UPDATE {database}.{table} SET {field} = REPLACE({field}, '{text_search}', '{text_to_replace}');
```

