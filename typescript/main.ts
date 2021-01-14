let greetings = 'Pruebas de Typescript'
let firstName:string = 'Arturo'
let lastName:string = 'López'
let secondLastName:string = 'Gómez'
let names:string[] = ['Juan', 'Jesus', 'Felipe']
names.push('Arturo')
let data:[boolean, string] = [true, 'hello']

function _greetings():void {
    console.log(greetings)
}

_greetings()

console.log(`${firstName} ${lastName} ${secondLastName}`)
names.forEach((val) => {
    console.log(val)
})

enum Roles { ADMIN = 1,  USER, GUEST }
let userRole:Roles = Roles.USER
console.log(userRole)
console.log(Roles[3])

let variable_any:any = 'Hello world'
console.log((<string>variable_any).toUpperCase())

function greetings_name(name:string) {
    return `Hello ${name}`
}

console.log(greetings_name((<string>variable_any)))

let get_greetings: (name:string) => void;

get_greetings = greetings_name

console.log(`Saludando desde get_greetings ${get_greetings((<string>variable_any))}`)

function alert_user() {
    console.log('Se lanza una alerta')
}

let get_user: () => void;

get_user = alert_user

console.log(`Obteniendo alerta de usuario`)
get_user()


function createPerson(firstName:string, lastName?:string) {
    return {
        firstName,
        lastName
    }
}

console.log(createPerson('Arturo'))

function createHero(name:string, power:string='Superhuman strength') {
    return {
        name,
        power
    }
}

console.log(createHero('Superman'))
console.log(createHero('Wolverine', 'Adamantium Skeleton'))

let superHero = {
    name: 'Logan',
    alias: 'Wolverine'
}

console.log(superHero)

superHero = {
    name: 'Charles Xavier',
    alias: 'Professor X'
}

console.log(superHero)

let person: {name: string, age:number, sayHello:() => string } = {
    name: 'Antonio',
    age: 28,
    sayHello() {
        return `Hello ${this.name} tu edad es ${this.age} años`
    }
}

console.log(person)
console.log(person.sayHello())

type Person = {
    name: string
    lastName: string
    age: number
    weight?: number
    sayAge:() => number
}

let personTwo: Person = {
    name: 'Pablo',
    lastName: 'Cabrera',
    age: 28,
    sayAge() {
        return this.age
    }
}

console.log(`La persona ${personTwo.name} ${personTwo.lastName} tiene ${personTwo.sayAge()} años`)

let personName: string|null|undefined = null
console.log(typeof personName)
personName = undefined
console.log(typeof personName)
personName = 'Xavier'
console.log(typeof personName)

function cycle():never {
    console.log('cycle')
    throw new Error('Existe un error')
    console.log('hello')
}

cycle()
