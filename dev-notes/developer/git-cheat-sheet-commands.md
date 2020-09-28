# Comandos útiles en Git

Comparar archivos entre el working area y el index (stage)
```bash
$ git diff 
```

Compara archivos entre el index (stage) y el repositorio 
```bash
$ git diff --cached
```

Comparar las diferencias entre ramas
```bash
$ git diff {branch1|develop} {branch2|master}
```

Eliminar archivos de stage
```bash
$ git rm --cached {filename}
```

Eliminar archivos de working área, index y repositorio 
```bash
$ git rm -f {filename}
```

Mover archivos
```bash
$ git mv {filename.txt} {filename.md}
```

Listado de branchs:
`$ git branch -l`

Listar branch remotos:
`$ git branch -r`

Eliminar un branch local:
`$ git branch -d <branch>`

Eliminar un branch remoto:
`$ git push <remote> :<branch>`

Mostrar las diferencias entre dos branches:
`$ git diff <branch> <branch>`

Ver solamente los archivos diferentes:
`$ git diff <branch> <branch> --name-only`

Ver las diferencias entre branch par un solo archivo:
`$ git diff <branch> <branch> <file>`

Ver las diferencias de un archivo entre commits:
`$ git diff <hash_commit> <hash_commit> <file>`

Listar los branch que han sido unidos(merge):
`$ git branch --merged`

Listar los branch que no han sido unidos(merge):
`$ git branch --no-merged`

Modificar un commit:
`$ git commit --amend`

Mostrar el ultimo commit en el log:
`$ git log -1 HEAD`

Subir cambios de un branch:
`$ git push origin <branch>`

Volver a un commit anterior y descartar los cambios:
`$ git reset --HARD <hash_commit>`

Ver y descargar un branch remoto:
`$ git remote show origin`

Si hay algun branch de la cual no tengamos los datos aún:
`$ git fetch origin`

Obtener un branch remoto:
`$ git checkout --track -b <branch> origin/<branch>` o `$ git checkout -t origin/<branch>`

Crear un branch basado en el HEAD:
`$ git branch <branch>`

Crear un branch basado en otro branch:
`\$ git checkout -b <new_branch> <branch>`

Eliminar un branch local:
`$ git branch -d <branch>`

Eliminar un branch remoto:
`$ git push origin <branch>`

Eliminar los branches remotos que ya no existan en origin (Ambos comandos hacen lo mismo):
`$ git fetch -p` o `$ git remote prune origin`

> Ejecutar con --dry-run para ver los cambios que realizará

Cambiar el nombre de una rama:
`$ git branch -m <branch_name> <branch_new_name>`

Copiar un commit determinado a un branch:
`$ git checkout <branch>` y luego `$ git cherry-pick <hash_commit>`

Mostrar los commits que no estan en el origen:
`$ git log origin/master..master`

Listado de branches remostos que contienen un commit:
`$ git branch -r --contains <hash_commit>`

## Trabajando con tags

Ver los tags locales:
`$ git tag`

Añadir un tag:
`$ git tag -a v1.2 <hash_commit>`

Subir tags al repositorio:
`$ git push --tags`

## Revertir commits

Deshacer el último commit (sin haber hecho push):
`$ git reset --soft HEAD~1`

Deshacer el último commit (habiendo hecho ya un push):
`$ git revert HEAD`

Deshacer el último commit (dejándolo como estaba con los archivos añadidos y demás):
`$ git reset --soft HEAD^`

Eliminar un commit:
`git reset HEAD~1`

## Flujo de stash

Agregamos un archivo:
`$ git add <file>`

Commit de los cambios:
`$ git commit -m "<message>"`

Agregamos los cambios al stash:
`$ git stash`

Obtenemos un branch diferente:
`$ git pull --rebase origin <branch>`

Subimos los cambios del branch:
`$ git push origin <branch>`

Obtenemos los cambios del stash:
`$ git stash pop`

## Configuraciones

[Ignorar el salto de línea en Git](http://help.github.com/line-endings/):
`$ git config --global core.autocrlf input`
