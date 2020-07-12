# Git dotfiles

Respaldar la configuración del entorno de desarrollo para mac o linux

Crear una carpeta en el home, la cual va a tener el repositorio de git:

```bash
$ mkdir $HOME/.dotfiles
```

Crear un repositorio sencillo de tipo bare en una carpeta:

```bash
$ git init --bare $HOME/.dotfiles
```

Definir un alias para el repositorio:

```bash
$ alias config='/usr/bin/git --git-dir=$HOME/.dotfiles/ --work-tree=$HOME'
```

Configurar git para que no muestre los archivos que no estan en el repositorio:

```bash
$ config config --local status.showUntrackedFiles no
```

Actualizar el shell:

```bash
$ echo "alias config='/usr/bin/git --git-dir=$HOME/.dotfiles/ --work-tree=$HOME'" >> $HOME/.zshrc
```

Ignoramos de manera global el directorio con el repositorio de la configuración:

```bash
$ echo ".dotfiles" >> .gitignore

# Referencia de la configuración global de gitignore
.DS_Store
.dotfiles
.idea/
.ssh/
.grails/
.eclipse/
.gradle/
.cache/
.bundle/
.gem/
.local/
.composer/
*.zwc
*.log
node_modules/
```

Agregamos el repositorio remoto:

```bash
$ config remote add origin git@github.com:lgzarturo/.dotfiles.git
```

Ahora ya se puede usar el comando config como si fuera git y ya se puede respaldar los archivos de configuración del entorno en el repositorio como el siguiente ejemplo:

```bash
$ config status
$ config add .vimrc
$ config commit -m "Add vimrc"
$ config add .zshrc
$ config commit -m "Add zshrc"
$ config push
```

## Instalar la configuración en otra maquina

Usar el siguiente comando

```bash
$ curl -Lks https://gist.github.com/lgzarturo/db1522f4ae051d8b6cc16bf5e8defae0 | /bin/zsh
```

o crear un script con el nombre de install-files.sh y asignarle privilegios de ejecución con el comando `$ chmod +x install-dotfiles.sh`

```bash
git clone --bare git@github.com:lgzarturo/.dotfiles.git $HOME/.dotfiles

function config {
   /usr/bin/git --git-dir=$HOME/.dotfiles/ --work-tree=$HOME $@
}

mkdir -p .dotfiles-backup

config checkout

if [ $? = 0 ]; then
  echo "Checked out config.";
  else
    echo "Backing up pre-existing dot files.";
    config checkout 2>&1 | egrep "\s+\." | awk {'print $1'} | xargs -I{} mv {} .dotfiles-backup/{}
fi;

config checkout

config config status.showUntrackedFiles no
```

## Referencia

- [Dotfiles](https://www.atlassian.com/git/tutorials/dotfiles)
- [Configure dotfiles with git bare](https://www.youtube.com/watch?v=tBoLDpTWVOM)
- [Dotfiles-WIP](https://github.com/memoriasIT/Dotfiles-WIP)
- [Gnome-terminal](https://github.com/agilesteel/.dotfiles/tree/master/gnome-terminal)
