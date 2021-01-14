# Proyecto de pruebas con Typescript

## Transpilar el codigo de typescript

npx tsc {file.ts}

## Revisar cambios

npx tsc -w {file.ts}

## Inicializar configuración de Typescipt

npx tsc --init

> Se crea un archivo json donde esta la configuración de typescript

## Tipos de datos

- Boolean
  let isGood:boolean = true

- Number
  let isNumber:number = 10

- String
  let isString:string = "Arturo"

- Array
  let names:string[] = ['Juan', 'Jesus', 'Felipe']

- Tuple
  let data:[boolean, string] = [true, 'hello']

- Enums
  enum Roles { ADMIN, USER, GUEST }
  let user:Roles = Roles.ADMIN

- Void
  function greetings():void {
  alert('hello')
  }
  let \_variable_undefined:void = undefined
  let \_variable_null:void = null

- Undefined
  let identifier:undefined = undefined

- Null
  let identifier:null = null

- Never
  function cycle():never {
  console.log('cycle')
  throw new Error('Existe un error')
  console.log('hello') <<- No llega hasta aqui ->>
  }

- Any
  let variable_any:{any} = 'Hello world'

## Funciones

- Parametros con tipo de datos
  function greetings(name:string) {
  return `Hello ${name}`
  }

- Definir funciones anonimas
  let get_greetings: (name:string) => void;

- Parametros opcionales
  function createPerson(firstName:string, lastName?:string) {
  retutun {
  firstName,
  lastName
  }
  }

- Parametros con valores por default
  function createPerson(firstName:string, lastName:string='Doe') {
  retutun {
  firstName,
  lastName
  }
  }

## Objetos

let superHero = {
name: 'Logan',
alias: 'Wolverine'
}

let person: {name: string, age:number} = {
name: 'Antonio',
age: 28
}

## Objeto personalizado

type Person = {
name: string
lastName: string
weight?: number // propiedad opcional en el tipo de objeto personalizado
age: number
sayAge:() => number
}

let person: Person = {
name: 'Pablo',
lastName: 'Cabrera'
age: 28,
sayAge() {
return this.age
}
}

- Union de tipos en variables
  let personName: string|null|undefined = null
