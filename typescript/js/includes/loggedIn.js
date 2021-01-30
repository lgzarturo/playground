"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var users_1 = require("./users");
function default_1() {
    console.log(localStorage.username);
    if (localStorage.username) {
        document.getElementById('loginButtonContainer').innerHTML = "<span>Hola " + users_1.getUsers()[0].username + "</span>";
        document.getElementById('addPhotoButtonContainer').innerHTML = "\n        <button class=\"btn btn-primary btn-block\">Agregar foto</button>\n        <button class=\"btn btn-danger btn-block\" id=\"logoutButton\">Salir</button>\n        ";
        $('#logoutButton').on('click', function (e) {
            e.preventDefault();
            localStorage.clear();
            window.location.reload();
        });
    }
}
exports.default = default_1;
