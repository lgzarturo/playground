"use strict";
var Greetings;
(function (Greetings) {
    function greeting() {
        console.log('Hola mundo desde un namespace');
    }
    Greetings.greeting = greeting;
})(Greetings || (Greetings = {}));
