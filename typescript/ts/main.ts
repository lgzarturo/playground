import {Automovile, Bus} from './includes/cars'
import * as Greetings from './greetings'
import { getUsers } from './includes/users'
import login from './includes/login'
import 'jquery'

// Esto es un comentario

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

class Car {
    static type:string = 'Automovil'
    static sayType() {
        console.log(Car.type)
    }
    name: string
    year: number
    model: string
    color: string
    doors: number
    private serialNumber: string
    public saySerialNumber() {
        console.log(this.serialNumber)
    }

    constructor(name: string, year: number, model: string, color: string, doors: number) {
        console.log('Creando la nueva instancia de la clase Car')
        this.name = name
        this.year = year
        this.model = model
        this.color = color
        this.doors = doors
        this.serialNumber = `UUID-${year}-${model}`
    }
}

let myCar = new Car('Figo', 2020, 'TM', 'Blue', 5)
console.log(myCar)
console.log(myCar.name)
myCar.saySerialNumber()
Car.sayType()

function cycle():never {
    console.log('cycle')
    throw new Error('Existe un error')
}

class Vehicle {
    private alertAboutType() {
        console.log(`From alert about type ${this.type}`)
    }
    protected getType() {
        console.log(`From getType ${this.type}`)
        return this.type
    }
    constructor(public type:string) {}
}

class Motorcycle extends Vehicle {
    constructor(type:string, public cc:number) {
        super(type)
        console.log(super.getType())
    }
}

abstract class TypeProduct {
    constructor(private _type:string){}
    get type():string {
        return this._type
    }
    set type(new_type:string) {
        this._type = new_type
    }
}

class Product extends TypeProduct {
    constructor(private _price:number) {
        super('Celphone')
    }
    get price():number {
        return this._price
    }
    set price(new_price:number) {
        if (new_price > this.price) {
            this._price = new_price
        } else {
            return
        }
    }
}

class Tablet extends TypeProduct {
    brand:string
    model:string
    constructor(brand:string, model:string, type:string) {
        super(type)
        this.brand = brand
        this.model = model
    }
}

let iphone = new Product(25000)
console.log(iphone.price)
iphone.price = 30000
console.log(iphone.price)
iphone.price = 25000
console.log(iphone.price)

let tablet = new Tablet('Samsung', 'Galaxy Tab S7', 'Tablet')
console.log(tablet)

let yamaha = new Motorcycle('Class yamaha', 150)
console.log(yamaha)

class Settings {
    static instance:Settings
    private constructor(public color:string, public logo:string) {}
    static build(color:string, logo:string) {
        if (!Settings.instance) {
            Settings.instance = new Settings(color, logo)
        }
        return Settings.instance
    }
}

let settings = Settings.build('yellow', 'logo.png')
console.log(settings)
let settings_copy = Settings.build('green', 'logo2.png')
console.log(settings_copy)

interface Birds {
    color: string
    size?: number
    type: string
    action(): string
}

let bird:Birds = {
    color: 'Blue',
    size: 2,
    type: 'Blue bird',
    action() {
        return `${this.type} is flying`
    }
}

console.log(bird.action())

class BlueBird implements Birds {
    constructor(public color:string, public type:string) {}
    action(): string {
        return `${this.type} is flying`
    }
}

let cyanBird = new BlueBird('Cyan', 'CyanBird')

console.log(cyanBird.action())

Greetings.greeting()

let automovile = new Automovile()

console.log(automovile)

let bus = new Bus()

console.log(bus)

bus.doors = function () {
    console.log('El autobus tiene 2 puertas dobles')
}

bus.doors()

console.log(getUsers())

document.getElementById('loginButton')!.addEventListener('click', (e) => {
    e.preventDefault()
    let username = (<HTMLInputElement>document.getElementById('username')).value;
    let password = (<HTMLInputElement>document.getElementById('password')).value;
    login(getUsers()[0], {username, password})
})

console.log($('#loginButton'))

cycle()
