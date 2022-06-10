#!/bin/zsh

error() {
  echo $1
  exit 1
}

if [ $# -ne 4 ]; then
  error "Uso: movefiles name ext number path"
fi

if [ ! -d $4 ]; then
  error "Error: El directorio no existe"
fi

if [ $3 -lt 1 ]; then
  error "Error el número de archivos debe ser mayor que 1"
fi

for (( i = 1; i <= $3; i++ )); do
  file_path="$4/$1-$i.$2"
  if [ $i -lt 10 ]; then
    file_path="$4/$1-0$i.$2"
  fi
  touch $file_path
  echo "Archivo creado $file_path" | tr -s /
done 

exit 0
