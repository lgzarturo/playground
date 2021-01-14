"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var greetings = 'Pruebas de Typescript';
var firstName = 'Arturo';
var lastName = 'López';
var secondLastName = 'Gómez';
var names = ['Juan', 'Jesus', 'Felipe'];
names.push('Arturo');
var data = [true, 'hello'];
function _greetings() {
    console.log(greetings);
}
_greetings();
console.log(firstName + " " + lastName + " " + secondLastName);
names.forEach(function (val) {
    console.log(val);
});
var Roles;
(function (Roles) {
    Roles[Roles["ADMIN"] = 1] = "ADMIN";
    Roles[Roles["USER"] = 2] = "USER";
    Roles[Roles["GUEST"] = 3] = "GUEST";
})(Roles || (Roles = {}));
var userRole = Roles.USER;
console.log(userRole);
console.log(Roles[3]);
var variable_any = 'Hello world';
console.log(variable_any.toUpperCase());
function greetings_name(name) {
    return "Hello " + name;
}
console.log(greetings_name(variable_any));
var get_greetings;
get_greetings = greetings_name;
console.log("Saludando desde get_greetings " + get_greetings(variable_any));
function alert_user() {
    console.log('Se lanza una alerta');
}
var get_user;
get_user = alert_user;
console.log("Obteniendo alerta de usuario");
get_user();
function createPerson(firstName, lastName) {
    return {
        firstName: firstName,
        lastName: lastName
    };
}
console.log(createPerson('Arturo'));
function createHero(name, power) {
    if (power === void 0) { power = 'Superhuman strength'; }
    return {
        name: name,
        power: power
    };
}
console.log(createHero('Superman'));
console.log(createHero('Wolverine', 'Adamantium Skeleton'));
var superHero = {
    name: 'Logan',
    alias: 'Wolverine'
};
console.log(superHero);
superHero = {
    name: 'Charles Xavier',
    alias: 'Professor X'
};
console.log(superHero);
var person = {
    name: 'Antonio',
    age: 28,
    sayHello: function () {
        return "Hello " + this.name + " tu edad es " + this.age + " a\u00F1os";
    }
};
console.log(person);
console.log(person.sayHello());
var personTwo = {
    name: 'Pablo',
    lastName: 'Cabrera',
    age: 28,
    sayAge: function () {
        return this.age;
    }
};
console.log("La persona " + personTwo.name + " " + personTwo.lastName + " tiene " + personTwo.sayAge() + " a\u00F1os");
var personName = null;
console.log(typeof personName);
personName = undefined;
console.log(typeof personName);
personName = 'Xavier';
console.log(typeof personName);
var Car = /** @class */ (function () {
    function Car(name, year, model, color, doors) {
        console.log('Creando la nueva instancia de la clase Car');
        this.name = name;
        this.year = year;
        this.model = model;
        this.color = color;
        this.doors = doors;
        this.serialNumber = "UUID-" + year + "-" + model;
    }
    Car.sayType = function () {
        console.log(Car.type);
    };
    Car.prototype.saySerialNumber = function () {
        console.log(this.serialNumber);
    };
    Car.type = 'Automovil';
    return Car;
}());
var myCar = new Car('Figo', 2020, 'TM', 'Blue', 5);
console.log(myCar);
console.log(myCar.name);
myCar.saySerialNumber();
Car.sayType();
function cycle() {
    console.log('cycle');
    throw new Error('Existe un error');
    console.log('hello');
}
var Vehicle = /** @class */ (function () {
    function Vehicle(type) {
        this.type = type;
    }
    Vehicle.prototype.alertAboutType = function () {
        console.log("From alert about type " + this.type);
    };
    Vehicle.prototype.getType = function () {
        console.log("From getType " + this.type);
        return this.type;
    };
    return Vehicle;
}());
var Motorcycle = /** @class */ (function (_super) {
    __extends(Motorcycle, _super);
    function Motorcycle(type, cc) {
        var _this = _super.call(this, type) || this;
        _this.cc = cc;
        console.log(_super.prototype.getType.call(_this));
        return _this;
    }
    return Motorcycle;
}(Vehicle));
var yamaha = new Motorcycle('Class yamaha', 150);
console.log(yamaha);
cycle();
