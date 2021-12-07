#!/bin/zsh

if [ ! -d $1 ]; then
  echo "Error: El directorio no existe"
  exit 1
fi

total=0
for file in `ls $1`; do
  file_path="$1/$file"
  if [ -f $file_path ]; then
    bytes=`ls -l $file_path | sed "s/  */ /g" | cut -d " " -f 5`
    (( total += $bytes ))
  fi
done

echo -e "\nEl directorio '$1' pesa $total bytes"
exit 0
