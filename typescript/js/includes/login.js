"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var loggedIn_1 = __importDefault(require("./loggedIn"));
function default_1(user, formData) {
    console.log("Login", user, formData);
    if (formData.username === user.username && formData.password === user.password) {
        localStorage.setItem('username', user.username);
        loggedIn_1.default();
    }
    else {
        return;
    }
}
exports.default = default_1;
