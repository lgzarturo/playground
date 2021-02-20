/*
Código de JavaScript básico
*/
console.log('Enlazando archivo externo');

// Obtener el nombre desde el navegador
var name = prompt('Cual es tu nombre?');
if (name === '' || name === 'null') {
    name = 'mundo';
}
const greetings = `Hola, ${name}!`;
alert(greetings);
document.querySelector('#name').innerHTML = greetings;

/*
Variables 
*/

// Asignando un valor a la variable
var iProduct = 'iPhone 12';
console.log(iProduct);

// Cambiando el valor de la variable
iProduct = 'iMac';
console.log(iProduct);

// Asignando otro tipo de dato a la variable
iProduct = 25000;
console.log(iProduct);

// Iniciar una variable sin valor
var isActive;
isActive = false;
isActive = true;

// Iniciar multiples variables
var color = '#fff', 
    title = 'Website',
    score = 5.0;
console.log({color, title, score});

let jedi = 'Grogu';
console.log(`${jedi} será jedi?`);

const price = 300.00;
console.log(`El precio de la constante es $${price}`);

console.log(new String('Cadena de texto desde la instancia de la clase String()'));