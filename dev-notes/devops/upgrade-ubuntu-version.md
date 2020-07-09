# Actualizar Ubuntu

Para actualizar la versión de Ubuntu se recomiendan los siguientes pasos:

> Estos pasos son para pasar de Ubuntu 16.04 a 18.04

Reemplazar el nombre clave de la versión de Ubuntu 

```bash
$ sudo sed -i 's/yakkety/bionic/g' /etc/apt/sources.list
$ sudo sed -i 's/zesty/bionic/g' /etc/apt/sources.list
$ sudo sed -i 's/^/#/' /etc/apt/sources.list.d/*.list
```

Actualizar el repositorio de paquetes

```bash
$ sudo apt update
```

Aplicar las actualizaciones disponibles

```
$ sudo apt upgrade
```

Realizar el upgrade de la distribución

```bash
$ sudo apt dist-upgrade
```

Hacer limpieza de los programas que ya no son relevantes en la nueva distribución

```bash
$ sudo apt autoremove
```

Aplicar la limpieza de paquetes viejos

```bash
$ sudo apt clean
```

Reiniciar el sistema

```bash
$ sudo shutdown -r now
```

Verificar la actualización del sistema

```bash
$ lsb_release  -a
```
