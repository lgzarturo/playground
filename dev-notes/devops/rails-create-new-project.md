# Crear nuevo proyecto con Rails y PostgreSQL

Agregar el path de PostgreSQL al archivo ~/.zshrc, ~/.bashrc o ~/.profile

`export PATH="Applications/Postgres.app/Contents/Versions/latest/bin:$PATH"`

Instalar el soporte de PostgreSQL para Ruby on Rails

`$ gem install pg`

Crear la aplicación con Rails

```bash
$ rails new rails_{name} -T --database=postgresql
$ cd rails_{name}
```

Actualizar la dependencia tzinfo-data

`$ bundle lock --add-platform x86-mingw32 x86-mswin32 x64-mingw32 java`

Refrescar la instalación de las dependencias

`$ bundle install`

Crear la base de datos

`$ rails db:create`

Aplicar las migraciones

`$ rails db:migrate`

Iniciar la aplicación
`$ rails s`

Abrir en el navegador y poner la dirección: `http://localhost:3000/`
