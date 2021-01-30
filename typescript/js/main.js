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
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var cars_1 = require("./includes/cars");
var Greetings = __importStar(require("./greetings"));
var users_1 = require("./includes/users");
var login_1 = __importDefault(require("./includes/login"));
require("jquery");
var loggedIn_1 = __importDefault(require("./includes/loggedIn"));
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
var Car = (function () {
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
}
var Vehicle = (function () {
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
var Motorcycle = (function (_super) {
    __extends(Motorcycle, _super);
    function Motorcycle(type, cc) {
        var _this = _super.call(this, type) || this;
        _this.cc = cc;
        console.log(_super.prototype.getType.call(_this));
        return _this;
    }
    return Motorcycle;
}(Vehicle));
var TypeProduct = (function () {
    function TypeProduct(_type) {
        this._type = _type;
    }
    Object.defineProperty(TypeProduct.prototype, "type", {
        get: function () {
            return this._type;
        },
        set: function (new_type) {
            this._type = new_type;
        },
        enumerable: false,
        configurable: true
    });
    return TypeProduct;
}());
var Product = (function (_super) {
    __extends(Product, _super);
    function Product(_price) {
        var _this = _super.call(this, 'Celphone') || this;
        _this._price = _price;
        return _this;
    }
    Object.defineProperty(Product.prototype, "price", {
        get: function () {
            return this._price;
        },
        set: function (new_price) {
            if (new_price > this.price) {
                this._price = new_price;
            }
            else {
                return;
            }
        },
        enumerable: false,
        configurable: true
    });
    return Product;
}(TypeProduct));
var Tablet = (function (_super) {
    __extends(Tablet, _super);
    function Tablet(brand, model, type) {
        var _this = _super.call(this, type) || this;
        _this.brand = brand;
        _this.model = model;
        return _this;
    }
    return Tablet;
}(TypeProduct));
var iphone = new Product(25000);
console.log(iphone.price);
iphone.price = 30000;
console.log(iphone.price);
iphone.price = 25000;
console.log(iphone.price);
var tablet = new Tablet('Samsung', 'Galaxy Tab S7', 'Tablet');
console.log(tablet);
var yamaha = new Motorcycle('Class yamaha', 150);
console.log(yamaha);
var Settings = (function () {
    function Settings(color, logo) {
        this.color = color;
        this.logo = logo;
    }
    Settings.build = function (color, logo) {
        if (!Settings.instance) {
            Settings.instance = new Settings(color, logo);
        }
        return Settings.instance;
    };
    return Settings;
}());
var settings = Settings.build('yellow', 'logo.png');
console.log(settings);
var settings_copy = Settings.build('green', 'logo2.png');
console.log(settings_copy);
var bird = {
    color: 'Blue',
    size: 2,
    type: 'Blue bird',
    action: function () {
        return this.type + " is flying";
    }
};
console.log(bird.action());
var BlueBird = (function () {
    function BlueBird(color, type) {
        this.color = color;
        this.type = type;
    }
    BlueBird.prototype.action = function () {
        return this.type + " is flying";
    };
    return BlueBird;
}());
var cyanBird = new BlueBird('Cyan', 'CyanBird');
console.log(cyanBird.action());
Greetings.greeting();
var automovile = new cars_1.Automovile();
console.log(automovile);
var bus = new cars_1.Bus();
console.log(bus);
bus.doors = function () {
    console.log('El autobus tiene 2 puertas dobles');
};
bus.doors();
console.log(users_1.getUsers());
loggedIn_1.default();
document.getElementById('loginButton').addEventListener('click', function (e) {
    e.preventDefault();
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    login_1.default(users_1.getUsers()[0], { username: username, password: password });
});
console.log($('#loginButton'));
cycle();
