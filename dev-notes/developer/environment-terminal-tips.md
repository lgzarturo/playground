# Tips de la Terminal

## Manejo de alias en la terminal

Para configurar los alias, es necesario registrarlos en el archivo de configuración de `vim ./zshrc` y para que estén disponibles `source ~/.zshrc`

### Normal alias

`alias [custom-alias]="[command]"`

Ejemplo:

```bash
alias install="sdk install"
alias remove="sdk uninstall"
```

Esto se traduce como:

- \$ **install grails 2.2.0** ~= _sdk install grails 2.2.0_
- \$ **remove grails 2.2.0** ~= _sdk uninstall grails 2.2.0_

### Suffix alias

`$ alias -s [file-extension]=[name-of-app]`

Ejemplo:

`alias -s txt=code`

Esto se traduce en:

- \$ **code readme.txt**

### Global alias

`$ alias -g [custom-alias]="[Command]"`

Ejemplos:

```bash
alias -g G="| grep"
alias -g L="| less"
alias -g GG="google.com"
```

Esto se traduce como:

- \$ **apt-cache search vlc G** ~= _apt-cache search vlc | grep data_
- \$ **cat readme.md L** ~= _cat readme.md | less_
- \$ **ping GG** ~= _ping google.com_

### Alias con parámetros

```bash
[alias-name]() {
    command $param1 | $param2
}
```

Ejemplo:

```bash
acs() {
    apt-cache search $1 | grep $2
}
```

Se traduce en:

- \$ **acs vlc data** ~= _apt-cache search vlc | grep data_
