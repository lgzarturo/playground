# Notas sobre PostgreSQL

## Dump database

Generar un respaldo de una base de datos en formato tar

`$ pg_dump -U db_user -W -F t db_name > /path/to/your/file/dump_name.tar`

### Argumentos

- **-U**: to specify which user will connect to the PostgreSQL database server.
- **-W**: or --password will force pg_dump to prompt for a password before connecting to the server.
- **-F**: is used to specify the format of the output file, which can be one of the following:
- **p**: plain-text SQL script
- **c**: custom-format archive
- **d**: directory-format archive
- **t**: tar-format archive

## Restore with psql with plain SQL script

`$ psql -U db_user db_name < dump_name.sql`

## Restore with pg_restore for .tar file, directory or custom format

`$ pg_restore -d db_name /path/to/your/file/dump_name.tar -c -U db_user`

### Argumentos
- **-c**: to drop database objects before recreating them,
- **-C**: to create a database before restoring into it,
- **-e**: exit if an error has encountered,
- **-F**: format to specify the format of the archive.

## Links

- https://axiomq.com/blog/backup-and-restore-a-postgresql-database/
