# Mejora tu entorno de desarrollo

## Docker

La mejor opción para instalar Docker en MacOS es descargar el paquete '.dmg' desde la página oficial: *https://www.docker.com/get-started*

La última versión de Docker se encuentra en el siguiente enlace: 

https://download.docker.com/mac/stable/Docker.dmg

> Si el **docker-compose** se pone lento, aplicar la siguiente configuración en el archivo *"/etc/hosts"*: `$ sudo -H vim /etc/hosts`, agregar la siguiente línea:
> `127.0.0.1 localhost localunixsocket`

> Si es necesario autenticarse descargar imágenes de docker usar el siguiente comando:
> `$ docker login --username {USERNAME}`

## Instalar Homebrew

El sitio de Homebrew es https://brew.sh, solo hay que ejecutar el siguiente script:

> Probar primero la instalación con ruby: 
> `$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`, 
> si no funciona primero hay que instalar Git: https://git-scm.com/download/mac 

`$ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"`

> Para instalar Homebrew se requiere Xcode, verificar si está instalado con el comando: 
> `$ xcode-select --install`

Al finalizar es necesario instalar los paquetes para el entorno

`$ brew update`

Verificar que toda la instalación sea correcta

`$ brew doctor`

## Instalar Git

Usando brew instalamos el paquete de git para Mac:

`$ brew install git`

> Es recomendable instalar la herramienta Git Flow: `$ brew install git-flow`

### Configurando Git

El sistema tiene 3 capas denominadas local, global y de sistema, las configuraciones de cada capa se encuentran en los siguientes archivos:

- Local: `{repositorio}/.git/config`
- Global: `Users/{usuario}/.gitconfig`
- System: `/usr/local/etc/gitconfig`

Primero configuramos la capa global con los datos del desarrollador

- Nombre: `$ git config --global user.name "{NAME}"`    
- Correo: `$ git config --global user.email "{EMAIL}"`    

Ahora modificamos los datos del editor **Visual Code Studio**:

`$ git config --global core.editor "code --new-window --wait"`

### Diff y Merge tools

Editamos el archivo de configuración:

`$ git config --global -e`

Agregar la configuración:

```
[diff]
  tool = vscode-diff
[difftool]
  prompt = false
[difftool "vscode-diff"]
  cmd = code --wait --diff $LOCAL $REMOTE
[merge]
  tool = vscode-merge
[mergetool]
  KeppBackup = false
[mergetool "vscode-merge"]
  cmd = code --wait $MERGED 
```

Para probar DiffTool y MergeTool, es necesario tener un repositorio con cambios en staging y ejecutamos los siguientes comandos respectivamente:

```
$ git difftool
$ git mergetool
```

### Git Aliases

Comandos de Git más fáciles de recordar: 

git status: *'git st'*

`$ git config --global alias.st status`

git status --short: *'git ss'*

`$ git config --global alias.ss 'st --short'`

git config --global -e: *'git egc'*

`$ git config --global alias.egc 'config --global -e'`

git config --local -e: *'git elc'*

`$ git config --global alias.elc 'config --local -e'`

git config --system -e: *'git esc'*

`$ git config --global alias.esc 'config --system -e'`

git checkout: *'git co'* 

`$ git config --global alias.co 'checkout'`

git branch: *'git br'* 

`$ git config --global alias.br 'branch'`

git commit: *'git co'* 

`$ git config --global alias.ci 'commit'`

git commit --amend: *'git amend'* 

`$ git config --global alias.amend 'co -a --amend'` 

git push --set-upstream origin develop: *'git pdev'*

`$ git config --global alias.pdev 'push --set-upstream origin develop'`

git push --set-upstream origin master: *'git pmaster'*

`$ git config --global alias.pmaster 'push --set-upstream origin master'`                 

## Instalar otras herramientas

Línea de comandos para procesar archivos json

`$ brew install jq`

Instalar java con Homebrew:

`$ brew install java`

> Esta forma más simple de instalar java, pero es recomendable instalar los JDK's con **SDKMan**: https://sdkman.io

### Java con SDKMan

Realizar la instalación de la herramienta SDKMan con el siguiente comando:

`$ curl -s "https://get.sdkman.io" | bash`

Actualizamos la terminal para que se inicialice la herramienta

`$ source "$HOME/.sdkman/bin/sdkman-init.sh"`

Instalamos la ultima versión de Java, Grails, Groovy, Micronaut, SpringBoot y VisualVM

```
$ sdk install java
$ sdk install grails
$ sdk install micronaut
$ sdk install springboot
$ sdk install visualvm
```

#### Configuración de Grails

Para configurar el entorno de runtime de Grails:

`$ echo 'export GRAILS_OPTS="-Xmx1G -Xms256m -XX:MaxPermSize=256m"' >> ~/.zshrc`

#### Configuración de VisualVM

Para hacer ejecutable el comando de *'$ visualvm'*:

`$ echo 'export PATH="$PATH:$VISUALVM_HOME/bin"' >> .zshrc`

> Para matar todos los procesos que este ejecutando la JVM: $ killall java

#### Python 2

Configuración de Python 2, para compatibilidad con otras herramientas:

`$ brew install python2`

Arreglando la configuración de Python 2 para que funcione junto con Python 3 sin problemas

```
$ brew install ansible
$ sudo -H easy_install pip
$ sudo -H /usr/bin/python -m pip install boto3 --ignore-installed six
$ brew unlink python
$ brew link --override python 
```

#### AWS SDK

Instalar boto3, el sdk de python para AWS

`$ brew install boto3 netaddr tree`

## Mejorar las conexiones SSH 

Prevenir el error *“Write failed: broken pipe”* en la connexion SSH

Editar el archivo de configuración de SSH: `$ vim ~/.ssh/config` 

```
Host *
ServerAliveInterval 120
TCPKeepAlive no
```

Reiniciar servicio de SSH

```
$ sudo launchctl stop com.openssh.sshd
$ sudo launchctl start com.openssh.sshd

o
     
$ sudo launchctl unload /System/Library/LaunchDaemons/ssh.plist
$ sudo launchctl load -w /System/Library/LaunchDaemons/ssh.plist
```

Proteger el archivo: `$ chmod 644 ~/.ssh/config`

## Terminal

> La mejor aplicación para la terminal en MacOS es iTerm2, solo es necesario descargar el paquete DMG y realizar la instalación: https://iterm2.com/downloads.html

### Instalar Zsh

> Documentación sobre Zsh y Oh my Zsh: https://github.com/robbyrussell/oh-my-zsh/wiki/Installing-ZSH#install-and-set-up-zsh-as-default

`$ brew install zsh`

Definir ZSH como Bash por default

`$ sudo chsh -s /bin/zsh`

ó buscando el comando *'zsh'*

`$ sudo chsh -s $(which zsh)`

> Un complemento perfecto para Zsh es el proyecto Oh My Zsh! https://ohmyz.sh/#install

Agregar la ruta de comandos disponibles al path

`$ echo 'export PATH="/usr/local/bin:$PATH"' >> ~/.zshrc`

#### Instalar ohmyz.sh con Curl

`$ sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"`

#### Instalar ohmyz.sh con Wget

`$ sh -c "$(wget https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh -O -)"`

> Una vez instalado ohmyz.sh ejecutar los siguientes comandos
> `$ zshconfig` 
> `$ bash -c "clear && /bin/zsh"`

### Instalar fuentes especiales para desarrolladores

> Más información sobre el proyecto Nerd Fonts: https://github.com/ryanoasis/nerd-fonts#font-installation

```
$ brew tap homebrew/cask-fonts
$ brew cask install font-hack-nerd-font
```

### Mejorar la apariencia de la terminal

Instalar el complemento Powerlevel9k

```
$ brew tap sambadevi/powerlevel9k
$ brew install powerlevel9k
```

> Powerlevel9k también se puede instalar con Git: 
> `$ git clone https://github.com/bhilburn/powerlevel9k.git ~/.oh-my-zsh/custom/themes/powerlevel9k`

Aplicar la configuración al Shell

`$ echo "source /usr/local/opt/powerlevel9k/powerlevel9k.zsh-theme" >> ~/.zshrc`

Instalar Power line Status

`$ pip3 install --user powerline-status`

Instalar el proyecto Janus

`$ curl -L https://bit.ly/janus-bootstrap | bash`

### Instalar plugins para ZSH

Completions

`$ brew install zsh-completions`

Syntax Highlighting

```
$ git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting

$ echo "source ${(q-)PWD}/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh" >> ${ZDOTDIR:-$HOME}/.zshrc

$ source /usr/local/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh
```

Auto Suggestions

`$ git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions`

Antigen

`$ curl -L git.io/antigen > .antigen.zsh`

Utilidades e integraciones para iTerm2

`$ curl -L https://iterm2.com/shell_integration/install_shell_integration_and_utilities.sh | bash`

Fzf: [Auto completado de comandos para la terminal](https://github.com/junegunn/fzf)

```
$ brew install fzf
$ $(brew --prefix)/opt/fzf/install
```

ZPlug: [Administrador de plugins para Zsh](https://github.com/zplug/zplug)

`$ curl -sL --proto-redir -all,https https://raw.githubusercontent.com/zplug/installer/master/installer.zsh | zsh`

ZPresto: [Herramienta para configurar Zsh](https://github.com/Solisol/zpresto)

`$ git clone --recursive https://github.com/sorin-ionescu/prezto.git "${ZDOTDIR:-$HOME}/.zprezto"`

```
$ setopt EXTENDED_GLOB \
  for rcfile in "${ZDOTDIR:-$HOME}"/.zprezto/runcoms/^README.md(.N); do \ 
  ln -s "$rcfile" "${ZDOTDIR:-$HOME}/.${rcfile:t}" \ 
  done
```

Aplicar el tema de nombre *'sorin'* para el bash Zsh

`$ zstyle ':prezto:module:prompt' theme 'sorin'`

> Verificar el archivo de configuración de ZSH '~/.zshrc', en el enlace hay un ejemplo de la configuración de las variables de entorno y del tema de la terminal: https://gist.github.com/lgzarturo/c55340f5d53720917b90c72c2b7e1786

> Ideas para hacer de la terminal un lugar más productivo: 
> [Terminal environment tips](https://github.com/lgzarturo/devops_notes/blob/master/developer/environment-terminal-tips.md)

## Desarrollo con Node

### Instalar Nodejs

Instalando la ultima versión de Nodejs con Homebrew

`$ brew install node`

### Actualizar NPM

Actualizando el administrador de paquetes NPM de manera Global

`$ npm install -g npm@latest`

Instalar Npx: [Npm package executor](https://github.com/npm/npx)

`$ npm install -g npx`

### GUI para administrar paquetes de Nodejs

Comando para instalar la interfaz gráfica:

`$ npm install -g npm-gui`

Y solo hay que ejecutar el siguiente comando:

`$ npm-gui localhost:9000`

### Yarn

Instalar el administrador de paquetes Yarn:

`$ brew install yarn`

### Descargar dependencias

Mejorar el soporte para [instalar dependencias de Nodejs](https://github.com/nathanhleung/install-peerdeps#readme)

##### Para NPM

`npm install -g install-peerdeps`

##### Para Yarn

`yarn global add install-peerdeps`

### Instalar paquetes indispensables de Nodejs 

Grunt Cli

`$ npm install -g grunt-cli`

Prettier

`$ npm install -g prettier`

Eslint

`$ npm install -g eslint eslint-plugin-prettier eslint-config-prettier eslint-plugin-node eslint-config-node`

> Inicializar el linter con Eslint: `$ eslint --init` 

Express

`$ npm install -D express`

Yeoman: [Herramienta para crear proyectos con Nodejs](https://yeoman.io)

`$ npm install -g yo@latest`

JHipster: [Herramienta para crear proyectos Java](https://www.jhipster.tech)

`$ npm i generator-jhipster -g`

> Probar npx para este proyecto de jHipster `$ npx install-peerdeps --dev -g generator-jhipster`

Linter de javascript con la [guía de desarrollo de Airbnb](https://github.com/airbnb/javascript)

`$ npx install-peerdeps --dev -g eslint-config-airbnb`

## Mejorar el soporte de Vim

`$ brew install macvim --env-std --with-override-system-vim`

## Generar llave SSH

`$ ssh-keygen -t rsa -b 4096 -C "{EMAIL}"`

Copiar la llave SSH

`$ pbcopy < ~/.ssh/id_rsa.pub`

## Instalar PHP 

`$ brew install php@7.3 phplint phpunit`

Configurar las variables de entorno para PHP

```
$ echo 'export PATH="/usr/local/opt/apr/bin:$PATH"' >> ~/.zshrc
$ echo 'export PATH="/usr/local/opt/apr-util/bin:$PATH"' >> ~/.zshrc
$ echo 'export PATH="/usr/local/opt/php@7.3/bin:$PATH"' >> ~/.zshrc
$ echo 'export PATH="/usr/local/opt/php@7.3/sbin:$PATH"' >> ~/.zshrc
```

Verificar la instalación

`$ php -v`

### Instalar Composer

```
$ php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"\ 
  php -r "if (hash_file('sha384', 'composer-setup.php') === 'c5b9b6d368201a9db6f74e2611495f369991b72d9c8cbd3ffbc63edff210eb73d46ffbfce88669ad33695ef77dc76976') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;"\ 
  php composer-setup.php\ 
  php -r "unlink('composer-setup.php');"
```

Hace composer ejecutable

```
$ mv composer.phar /usr/local/bin/composer
$ sudo chmod a+x /usr/local/bin/composer
```

### Instalar Laravel

`$ composer global require laravel/installer`

Agrear la variable de entorno de los proyectos que se instalen con composer

`$ echo 'export PATH="/Users/arturolopez/.composer/vendor/bin:$PATH"' >> ~/.zshrc`

Crear un proyecto con laravel

`$ laravel new project {PROJECT_NAME}`

Ejecutar el proyecto

```
$ cd {PROJECT_NAME}
$ php artisan serve
```

Instalar valet

`$ composer global require laravel/valet`

Inicializar el proyecto de valet

`$ valet install`

Poner en ejecución un proyecto con valet

```
$ cd {PROJECT_NAME}
$ valet park
```

## Instalar Hugo

`$ brew install hugo`

Crear un sitio con Hugo

```
$ hugo new site {SITE_NAME}
$ cd {SITE_NAME}
```

Agrear un tema de hugo al sitio

```
$ git submodule add https://github.com/cowboysmall-tools/hugo-devresume-theme.git themes/devresume
$ echo 'theme = "devresume"' >> config.toml
```

Crear un articulo

`$ hugo new posts/first-post.md`

Ejecutar el sitio web

`$ hugo server -D`

## Sonarqube

Esta es una [herramienta](https://www.sonarqube.org/downloads/) para medir la calidad del código fuente

> Con Docker se puede instalar la sonarqube: `$ docker run -d --name sonarqube -p 9000:9000 sonarqube` las credenciales de acceso del sistema son *(login=admin, password=admin)*.

Descargar el proyecto del siguiente enlace: 

https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-8.3.0.34182.zip

Descomprimir el archivo y acceder a la carpeta:

`$ cd runtime/sonarqube-8.1.0.34182`

Configurar la variable de entorno y reiniciar ZSH

```
$ echo 'export PATH="$PATH:/Users/arturolopez/runtime/sonarqube-8.1.0.31237/bin"' >> .zshrc
$ source .zshrc
```

Ejecutar la herramienta

`$ sonar.sh start`

Comandos para trabajar con sonarqube
```
$ sonar.sh restart
$ sonar.sh status
$ sonar.sh stop
$ sonar.sh dump
$ sonar.sh console
```

### Sonar scanner

Para analizar el código fuente se usa [sonar scanner](https://docs.sonarqube.org/latest/analysis/scan/sonarscanner/)

> Con Docker se puede analizar el directorio del proyecto con el siguiente comando: 
> `docker run -e SONAR_HOST_URL=http://localhost:9000 -it -v "$(pwd):/usr/src" sonarsource/sonar-scanner-cli` 
> se pueden usar los parámetros *'SONAR_TOKEN, SONAR_LOGIN y SONAR_PASSWORD'* para más información: 
> https://github.com/sonarsource/sonar-scanner-cli-docker/

Descarga el scanner del siguiente enlace:

https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-4.3.0.2102-macosx.zip

Descomprimir el archivo y acceder a la carpeta:

`$ cd runtime/sonar-scanner-4.3.0.2102-macosx/bin`

Ejecutar el comando sonar-scanner

```
$ sonar-scanner \
  -Dsonar.projectKey={PROJECT_NAME} \
  -Dsonar.sources=. \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login={TOKEN}
```

## Sourcegraph

Herramienta para [analizar y entender código fuente](https://docs.sourcegraph.com/)

```
$ docker run --publish 7080:7080 \ 
  --publish 127.0.0.1:3370:3370 --rm \ 
  --volume ~/.sourcegraph/config:/etc/sourcegraph \ 
  --volume ~/.sourcegraph/data:/var/opt/sourcegraph sourcegraph/server:3.15.1
```

## Instalar KDiff

```
$ brew cask install kdiff3
$ sudo xcode-select --switch /Library/Developer/CommandLineTools
```

## Instalar MySql

### Con Docker

Descargar la imagen de mysql, especificando la versión

`$ docker pull mysql:5.7.28`

Crear un volumen para persistir las bases de datos

`$ docker volume create mysql-db-data`

Ejecutar y vincular la imagen de mysql con el volumen

`$ docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=root --mount src=mysql-db-data,dst=/var/lib/mysql mysql:5.7.28`

Ejecutar mysql

`$ docker run mysql-db`

### Con Homebrew

Instalar mysql especificando la versión

`$ brew install mysql@5.7`

Configurar la variable de entorno

`$ echo 'export PATH="/usr/local/opt/mysql@5.7/bin:$PATH"' >> ~/.zshrc`

Ejecutar el servicio

`$ brew services start mysql@5.7`

### Iniciar la configuración

`$ mysql_secure_installation`

## Instalar imagen de JDK 7

`$ docker pull circleci/openjdk:7-jdk`

## Instalar Nginx

`$ docker pull nginx`

Iniciar nginx apuntando a un folder

`$ docker run -d -p 80:80 -v ~/IdeaProjects/html/:/usr/share/nginx/html nginx`

Iniciar el contenedor de nginx

`$ docker start nginx`

## Instalar Elasticsearch

`$ docker pull elasticsearch:7.4.2`

## Instalar Kibana

`$ docker pull docker.elastic.co/kibana/kibana:7.4.2`  

## Más fuentes para desarrollo

**Adobe fonts**

https://github.com/adobe-fonts/source-code-pro

**SourceCode fonts**

https://github.com/powerline/fonts/tree/master/SourceCodePro

**Awesome terminal fonts**

https://github.com/gabrielelana/awesome-terminal-fonts

# Enlaces

- https://github.com/Powerlevel9k/powerlevel9k/wiki/Show-Off-Your-Config
- https://hackernoon.com/how-to-trick-out-terminal-287c0e93fce0
- https://github.com/Powerlevel9k/powerlevel9k#available-prompt-segments
- https://github.com/hnarayanan/shpotify
- https://github.com/johnelse/spotify-cli
