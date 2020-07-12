# Crear un nuevo proyecto con Django

> Crear entornos virtuales para gestionar proyectos con Python

## Paso 1

Instalar pip para la resolución de dependencias.

`$ sudo easy_install pi`

## Paso 2

Instalar virtualenv para los entornos virtuales de Python

```bash
$ pip install virtualenv
$ pip3 install virtualenv
```

## Paso 3

Iniciar el entorno del entorno virtual para instalar las dependencias del archivo requirements.txt

```bash
$ cd {PROJECT_NAME}
$ virtualenv -p python3 .venv
```

## Paso 4

Activar el entorno de desarrollo

`$ source .venv/bin/activate`

## Paso 5

Activar el entorno de desarrollo

```bash
$ pip install django
$ django-admin startproject {project_name}
```

## Notas adicionales

Revisar las dependencias instalas en el proyecto

`$ pip freeze`

Instalar las dependencias del proyecto listadas en el archivo requirements.txt

`$ pip install -r requirements.txt`
