"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Bus = exports.Automovile = void 0;
function hello(constructor) {
    constructor();
}
function method_editable(isWritable) {
    return function (target, property, descriptor) {
        descriptor.writable = isWritable;
    };
}
function editable(isWritable) {
    return function (target, property) {
        var descriptor = {
            writable: isWritable
        };
        return descriptor;
    };
}
function execute_constructor(isExecutable) {
    if (isExecutable) {
        return hello;
    }
    else {
        return null;
    }
}
var Automovile = (function () {
    function Automovile() {
        console.log("Hola estas en carro");
    }
    Automovile = __decorate([
        execute_constructor(false)
    ], Automovile);
    return Automovile;
}());
exports.Automovile = Automovile;
var Bus = (function () {
    function Bus() {
        this.plate = 123;
    }
    Bus.prototype.doors = function () {
        console.log("Numero de puertas");
    };
    __decorate([
        editable(true)
    ], Bus.prototype, "plate", void 0);
    __decorate([
        method_editable(true)
    ], Bus.prototype, "doors", null);
    return Bus;
}());
exports.Bus = Bus;
