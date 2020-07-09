# Herramientas para el entorno de desarrollo

1. Xcode

   Instalar Xcode para las librerias de desarrollo 

   ```bash
   $ xcode-select --install
   ```

2. Homebrew: [pasos para la instalación](https://github.com/lgzarturo/devops_notes/blob/master/developer/environment.md#instalar-homebrew)

   Actualizar los paquetes con el comando: `$ brew update`

3. iTerm2

   Se puede instalar con brew mediante el comando `$ brew cask install iterm2`, o mediante la descarga desde la el [sitio web del proyecto](https://github.com/lgzarturo/devops_notes/blob/master/developer/environment.md#terminal).

4. ZSH con oh my zsh!: [Aquí estan los pasos para la instalación del shell Zsh](https://github.com/lgzarturo/devops_notes/blob/master/developer/environment.md#instalar-zsh)

5. OSX Productivity 

   - Window Management con 
   - Quick Launcher con Alfred 4: Instalar alfred con brew `$ brew cask install alfred`
   - Tab swich app con [Hyperswitch](https://bahoom.com/hyperswitch)

6. OSX Settings 

   - Dock: Ocultar el dock, eliminar enlaces innecesarios, alinearlo a la izquierda y ajustar el tamaño al mínimo.
   - Finder: Mostrar extensiones de los archivos

7. Chrome y Firefox - Extensions: `$ brew cask install firefox google-chrome`

   - AdBlock
   - Privacy Badger
   - OneTab
   - JSONViewer
   - Stylus
   - Vue Devtools
   - React Devtools

8. Node.js: [Seguir los pasos para la instalación](https://github.com/lgzarturo/devops_notes/blob/master/developer/environment.md#instalar-nodejs)

   - nvm

     ```bash
     # Revisar la versión de nvm https://github.com/nvm-sh/nvm#installing-and-updating
     $ curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.35.3/install.sh | bash
     $ nvm install stable
     ```

   - yarn: `$ npm install -g yarn`

   - eslint: `$ npm install -g eslint`

   - lite server: `$ npm install -g lite-server`

9. Code Editor - VSCode: Se puede instalar con brew con el siguiente comando: `$ brew cask install visual-studio-code`

10. Break timer con [Time out - break reminders](https://apps.apple.com/mx/app/time-out-break-reminders/id402592703?mt=12)

11. Extra

    Instalar fortune, cowsay y ponysay: `$ brew install fortune cowsay ponysay`

    ```bash
    # Configurar el shell para que salga el mensaje de saludo con un dibujo en pixel art
    $ fortune | cowsay
    $ fortune | ponysay
    $ fortune | ponythink -c -bascii
    ```

## Configuración de VSCode

### Tipos de fuente para desarrollo

- [Anonymous Pro](https://www.marksimonson.com/fonts/view/anonymous-pro)
- [Hack Nerd Font](https://github.com/ryanoasis/nerd-fonts)
- [Fira Code](https://github.com/tonsky/FiraCode)
- [Jetbrains Mono](https://www.jetbrains.com/es-es/lp/mono/#how-to-install)

### Extensiones

[Mi lista completa de extensiones y configuración de vscode](https://gist.github.com/lgzarturo/b358672f882f22841567bc0755629050#file-extensions-json)

### Temas

- Temas actual:
  - [Just Black](https://marketplace.visualstudio.com/items?itemName=nur.just-black)
  - [Seti-Monokai](https://marketplace.visualstudio.com/items?itemName=SmukkeKim.theme-setimonokai)
  - [Seti-Black](https://marketplace.visualstudio.com/items?itemName=bobsparadox.seti-black)
- [Material Icon Theme](https://marketplace.visualstudio.com/items?itemName=PKief.material-icon-theme)
- [Bracket Pair Colorizer 2](https://marketplace.visualstudio.com/items?itemName=CoenraadS.bracket-pair-colorizer-2)

### Flujo de trabajo

- [advanced-new-file](https://marketplace.visualstudio.com/items?itemName=patbenatar.advanced-new-file): Sirve para crear archivos en cualquier parte del area de trabajo con shortcuts `cmd+alt+n (Mac), ctrl+alt+n (Win, Linux)`
- [Auto Close Tag](https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-close-tag): Cierra de manera automatica los tags de html y xml
- [Auto Rename Tag](https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-rename-tag): Sirve para renombrar los tags de html y xml
- [Toggle Quotes](https://marketplace.visualstudio.com/items?itemName=BriteSnow.vscode-toggle-quotes): Alternar el uso de comillas simples o dobles con un shortcut `cmd '` (`ctrl '` on win/linux) 

### Auto completado

- [IntelliSense for CSS class names in HTML](https://marketplace.visualstudio.com/items?itemName=Zignd.html-css-class-completion)
- [npm Intellisense](https://marketplace.visualstudio.com/items?itemName=christian-kohler.npm-intellisense)
- [Path Intellisense](https://marketplace.visualstudio.com/items?itemName=christian-kohler.path-intellisense)
- [Vetur](https://marketplace.visualstudio.com/items?itemName=octref.vetur)

### Formateo de código

- [ESLint](https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint)
- [Beautify](https://marketplace.visualstudio.com/items?itemName=HookyQR.beautify), [Prettier - Code Formatter](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)

