# Comandos de Vim

- **H** - Desplazamiento a la parte superior de la pantalla
- **L** - Desplazamiento a la parte inferior de la pantalla
- **G** - Nos lleva hasta el final del documento
- **w** - Desplazamiento una palabra a la derecha
- **b** - Desplazamiento una palabra a la izquierda
- **0** - Nos lleva hasta el inicio de la línea actual
- **\$** - Nos lleva hasta el final de la línea actual
- **Ctrl+B** - Función similar a Repag.
- **Ctrl+F** - Función similar a Avpag.
- **i** - Comienza a introducir texto en la posición actual del cursor
- **I** - Comienza a introducir texto al inicio de la línea donde se encuentra el cursor
- **O** - Inserta una línea en blanco antes de la línea actual
- **o** - Inserta una línea en blanco después de la línea actual
- **r** - Sustituye el carácter en la posición actual del cursor
- **R** - Sobrescribe desde la posición actual del cursor
- **x** - Borra el carácter de la actual posición del cursor
- **X** - Borra el carácter siguiente a la actual posición del cursor
- **dd** - Corta la línea actual (disponible en el portapapeles)
- **D o d\$** - Corta desde la posición actual del cursor hasta el final de la línea
- **yy o Y** - Copia al completo la línea donde se encuentra el cursor
- **yX** - Copia tantos caracteres desde la posición del cursor, como le pasemos sustituyendo X por un número que estimemos necesario.
- **P** - Pega en la línea previa a la que nos encontremos el contenido del portapapeles
- **p** - Pega en la línea siguiente a la que nos encontremos el contenido del portapapeles
- **.** - Repite el último comando
- **u** - Deshace el último comando
- **U** - Deshace el último comando aplicado a la línea donde se encuentre el cursor
- **n** - Encuentra la siguiente coincidencia en una búsqueda
- **N** - Encuentra la coincidencia anterior en una búsqueda
- **:n** - En el caso de tener varios archivos abiertos a la vez, nos llevará al siguiente fichero.
- **:N** - En el caso de tener varios archivos abiertos a la vez, nos llevará al fichero previo.
- **:buffers** - Muestra un listado de los ficheros abiertos en el momento de la solicitud y el estado en que se encuentran
- **:buffer X** - Nos lleva al fichero que le indiquemos sustituyendo X por el número de orden por el que se han abierto los archivos.
- **:e ‘Archivo’** - Inserta el contenido de un fichero en la línea donde se encuentra el cursor
- **:r** - Inserta el contenido de un fichero en la línea siguiente a la posición del cursor
- **:w o :w ‘Archivo’** - Escribe los cambios en el fichero (desde el buffer) o Escribe los cambios en otro fichero que le pasemos
- **:q** - Sale de Vi / Vim sin guardar los cambios
- **:wq o x! o ZZ** - Guarda los cambios en el archivo actual y sale de Vi / Vim.
- **:r! ‘Comando’** - Ejecuta un comando en la consola del sistema e inserta la salida de dicho comando en el fichero actual, desde la posición del cursor.

## Búsqueda y Sustitución

Con Vi/Vim tenemos la posibilidad de llevar el cursor directamente a una ubicación en concreto, basándonos en la
búsqueda dentro del texto, cosa que es perfecta si queremos sustituir cierto término por otro.

Con el comando `:/` podremos buscar en todo el documento la palabra que escribamos tras el carácter de la barra (`/`)
y moveremos el cursor hasta el primer resultado que coincida. Si en un documento quisiéramos encontrar `polimorfia`,
escribiríamos `:/polimorfia` lo que nos llevaría a la primera aparición en el documento de dicha palabra.

Conociendo esto, sustituir una palabra por otra, es tan fácil como seguir el formato `%s/sustituida/sustituta/`.
Como siempre, un ejemplo para esclarecer un poco más esto último. Si quisiéramos sustituir `Openwebinars` por
`Openwebinars.net`, esta sería la forma de expresarlo:

`:%s/Openwebinars/Openwebinars.net/gc`

A la hora de solicitar confirmación, Vi/Vim nos ofrecerá una serie de opciones que paso a detallar:

- **y** : Confirmamos la acción
- **n** : Saltamos esta coincidencia con la búsqueda sin sustituirla y pasamos a la siguiente
- **a** : Confirmamos la acción para esta y todas las siguientes coincidencias
- **q** : Dejamos de sustituir en la búsqueda
- **l** : Confirmamos la sustitución y paramos la búsqueda saliendo de nuevo al modo editor
- **Ctrl+e** : Avanzamos un poco hacia abajo en el documento para localizar el contexto de la coincidencia
- **Ctrl+y** : Retrocedemos un poco en el texto para localizar el contexto de la coincidencia.

## Enlaces

- [Manual de Vim](https://openwebinars.net/blog/vim-manual-de-uso-basico/)
