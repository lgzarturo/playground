# Nodejs

> JavaScript is Everywhere - web - server - mobile - desktop

Boilerplate == Ahorro de tiempo, tienen muchas caractéristicas integradas y son entornos probados.

Desarrollo propio == Libertad de organización, entiendes el detalle, decides las tecnologías que aplicas.

- Sinonimos de JavaScript Development Environment

### Aplicar buenas practicas en el desarrollo de JavaScript.

1. Configurar el IDE - WebStorm para NodeJS, aplicar el estándar con "editorconfig.org" para la edición de archivos acorde al gusto de cada programador.
2. Escoger el administrador de paquetes.

    Bower, npm, jspm, jam, volo, yarn

3. Instalar Nodejs

    Package.json contiene la lista de paquetes que se están usando en el proyecto.

Exponer una aplicación de Node para compartir los avances en el desarrollo

### localtunnel  (deprecado)

$ npm install localtunnel -g 

iniciar la aplicacion

$ lt —port 3000 —subdomain ats

### ngrok

$ npm install ngrok -g 

iniciar la aplicacion

./ngrok http 80

### now ~ vercel

$ npm install now -g 

crear un script para iniciar el servicio

$ now

### Surge

Exponer archivos estáticos (dominio personalizado)

$ npm install surge -g

$ surge

## Automatización

### Grunt

Tiene muchos plugins

Es el mas usado

### Gulp

Rápido

Se carga en memoria

### Npm scripts

Se declara en el package.json

Simple 

Facil de aprender

Mejor documentado

## Linting

JSLint

JSHint

ESLint → es el más popular.

ESLint se puede configurar en los siguientes archivos

- .eslintrc.js
- .eslintrc.yaml
- .eslintrc.yml
- .eslintrc.json
- .eslintrc → este es el fotmato mas popular
- package.json

ESLint Plugins

eslint-plugin-react

eslint-plugin-node

Warning

Se pueden ignorar

Puede continuar el desarrollo

Es opcionar corregir los warnings

Error

No se pueden ignorar

Rompe el proceso de desarrollo

El equipo esta forzado a corregir los errores

### Testing node.js apps.

Hay tres estilos de pruebas para el código.

- Unit - Son sencillas pruebas unitaras para cada modulo o función dentro del código. Es el nivel mas pequeño de codigo y se llama unidad.
- Integration: Son pruebas donde se emulan datos (mock data) para la comunicación entre modulos. Se prueban multiples unidades.
- UI: Son pruebas automatizadas para verificar la interación con la interfaz de usuario por medio de navegador. (Selenium)

Para cada tipo de prueba hay que elegir las herramientas necesarias como por ejemplo: El Framework, las librerias (assertions y helpers), que vamos a probar, donde se va a poner el código de las pruebasd y por ultimo la automatización en la ejecución de las pruebas.

### Unit test frameworks

Mocha → Junto con Jest es de los mas populares.

Jasmine

Tape

QUnit - jQuery

AVA - pruebas en paralelo

Jest - Facebook

### Assertion libraries

Chai → Es el mas popular

Should.js

expect

### Helper Library

JSDOM - Simula el DOM del navegador

Cheerio - Es un DOM basado en jQuery Selectors para realizar consultas a un DOM Virtual

### Run Test

Browser - Karma, Testem

Headless Browser - PhantomJS

DOM en memoria - JSDOM - Es una alternativa ligera.

### Opciones populares para testing

- Mocha - Test Framework (mochajs.org)
- Chai - Assertion Library (www.chaijs.com)
- Sinon - Spies, Stubs and Mocks (sinonjs.org)
- Istanbul - Code Coverage (istanbul.js.org)

---

Extensiones recomendadas para NodeJS

- HTML CSS Support
- JavaScript (ES6) code snippets
- JS-CSS-HTML  Formatting
- Terminal
- TypeScript Importer
- TSLint

NVM

Manejar diferentes versiones de nodejs

Para instalar NVM solo hay que ejecutar el siguiente comando:

```bash
$ curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.35.3/install.sh | zsh
```

> Para mayor referencia visitar las notas del proyecto [https://github.com/nvm-sh/nvm](https://github.com/nvm-sh/nvm)

Ahora para instalar una versión especifica de node se usa el siguiente comando:

```bash
$ nvm install v{VERSION}
```

Con el comando `$ nvm install node` se realiza la instalación de la última version estable de nodejs

Para cambiar de versión:

```bash
$ nvm use v{VERSION}
```

Serveless framework

Para desarrollar aplicaciones serverless se puede usar el serverless framework, para instalarlo solo es necesario el siguiente comando:

```bash
# El paquete se instala de manera global
$ npm i serverless -g
```

AWS CLI

Para administrar los servicios de AWS se requiere la instalación de la linea de comandos, con un paquete que se instala por medio de la herramienta pip incluida en python3.

```bash
$ pip3 install awscli --upgrade --user
```

Para configurar la herramienta de awscli, es necesario ejecutar el siguiente comando y proporcionar las credenciales de AWS

```bash
$ aws configure
```

Serverless Applications

Componentes

- Funciones - Lambda
- Enventos - API Gateway, Schedule, S3, CloudWatch, DynamoDB, Alexa Skills
- Recursos - DynamoDB, S3, CloudFront, Cognito
- Servicios - Cloudformation

Una función lambda tiene los siguientes elementos.

Archivo serverless.yml contiene la información de la configuración del servicio.

Código fuente - funciones

Dependencias - custom code, npm packages y serverless plugins

JavaScript

- Para recorrer los array es mejor usar map o forEach para los bucles.

```jsx
const numbers = [1, 2, 3, 4, 5, 6, 7, 8]

// DON'T
for (i = 0; i < numbers.length; i++) {
  console.log(i); // 1, 2, 3, 4, 5, 6, 7, 8
}

// DO

numbers.map(number => console.log(number)); // 1, 2, 3, 4, 5, 6, 7, 8

// OR 

numbers.forEach(number => console.log(number)); // 1, 2, 3, 4, 5, 6, 7, 8
```

Sin embargo para una lista de objetos es mejor usar el bucle for

```jsx
const dogs = { 
  name: "Sam",
  age: 10,
 }

// Looping over objects

for (let prop in dogs) {
  console.log(prop); // "name", "age"
}

Object.keys(dogs).forEach(key => {
   console.log(`${key} : ${dogs[key]}`);
  // "name : Sam"
  // "age : 10"
});

Object.values(dogs).forEach(value => console.log(value)); // "Sam", 10

Object.entries(dogs).forEach(([key, value])=>{
    console.log(`${key}:${value}`)
    //"name:Sam"
    //"age:10"
})
```

- Por default usar contantes en vez de variables.

Es recomendable el uso de const en vez de let

Evita el uso de muchas anidaciones de codigo.

Mal uso

```jsx
const names = ["Indrek", "Trevor", "Anna", "Buck"]

const lowerCaseNames = names.map(name => {
 return name.toLowerCase()
})

console.log(lowerCaseNames); // ["indrek", "trevor", "anna", "buck"]
```

Mejor practica

```jsx
const names = ["Indrek", "Trevor", "Anna", "Buck"]

const namesToLowerCase = name => name.toLowerCase()

const lowerCaseNames = names.map(namesToLowerCase)

console.log(lowerCaseNames); // ["indrek", "trevor", "anna", "buck"]
```

Mal uso

```jsx
const students = [
  {
    name: "Indrek",
    score: 33.99
  },
  {
    name: "John",
    score: 50.35
  },
  {
    name: "Alice",
    score: 63.35
  }
];
                

const calcAverageScore = students.reduce((accumulator, currentValue) => {
	  return Math.round(accumulator + currentValue.score)
}, 0)

console.log(calcAverageScore); // 147
```

Mejor uso

```jsx
const students = [
  {
    name: "Indrek",
    score: 33.99
  },
  {
    name: "John",
    score: 50.35
  },
  {
    name: "Alice",
    score: 63.35
  }
];
                

const addScores = (accumulator, currentValue) => Math.round(accumulator + currentValue.score)

const calcAverageScore = students.reduce(addScores, 0)

console.log(calcAverageScore); // 147
```

- Evita el uso de la anidación de sentencias IF

Mal uso

```jsx
if (hasName) {
  if (hasSurname) {
    if (favouriteDrink === "water") {
      console.log(hasName, hasSurname, favouriteDrink)
    }
  }
}
```

Mejor practica

```jsx
if (hasName && hasSurname && favouriteDrink === "water") {
  console.log(hasName, hasSurname, favouriteDrink)
}
```

- Es mejor usar variabes boleanas en vez de complicadas clausulas en las sentencias IF

Mal uso

```jsx
const person = {
  name: "Indrek",
  age: 26,
  pets: {
    name: "Simmo",
    type: "cat",
    age: 8.5
  }
}

if (person.name === "Indrek" && person.age === 26 && person.pets && person.pets.type === "cat") {
 console.log("You're definitely Indrek")
}
```

Mejor uso

```jsx
const person = {
  name: "Indrek",
  age: 26,
  pets: {
    name: "Simmo",
    type: "cat",
    age: 8.5
  }
}

const isIndrek = person.name === "Indrek" && person.age === 26 
const hasPets = person.pets && person.pets.type === "cat"

if (isIndrek && hasPets) {
 console.log("You're definitely Indrek")
}
```