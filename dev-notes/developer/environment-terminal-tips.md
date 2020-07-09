# Tips de la Terminal

## Manejo de alias en la terminal

Para configurar los alias, es necesario registrarlos en el archivo de configuración de `vim ./zshrc` y para que estén disponibles `source ~/.zshrc`

### Normal alias

`alias [custom-alias]="[command]"`

Ejemplo:

```
alias install="sdk install"
alias remove="sdk uninstall"
```

Esto se traduce como: 

- $ **install grails 2.2.0** ~= *sdk install grails 2.2.0*
- $ **remove grails 2.2.0** ~= *sdk uninstall grails 2.2.0*

### Suffix alias

`$ alias -s [file-extension]=[name-of-app]`

Ejemplo: 

`alias -s txt=code`

Esto se traduce en:

- $ **code readme.txt**

### Global alias

`$ alias -g [custom-alias]="[Command]"`

Ejemplos:

```
alias -g G="| grep"
alias -g L="| less"
alias -g GG="google.com"
```

Esto se traduce como:

- $ **apt-cache search vlc G** ~= *apt-cache search vlc | grep data*
- $ **cat readme.md L** ~= *cat readme.md | less*
- $ **ping GG** ~= *ping google.com*

### Alias con parámetros

```
[alias-name]() {
    command $param1 | $param2
}  
```

Ejemplo:

```
acs() {
    apt-cache search $1 | grep $2
}  
```

Se traduce en:

- $ **acs vlc data** ~= *apt-cache search vlc | grep data*
