/*
Código de JavaScript básico
*/
console.log('Enlazando archivo externo')

/*
Variables
*/

// Asignando un valor a la variable
var iProduct = 'iPhone 12'
console.log(iProduct)

// Cambiando el valor de la variable
iProduct = 'iMac'
console.log(iProduct)

// Iniciar una variable sin valor
var isActive
isActive = false
isActive = true

// Iniciar multiples variables
var color = '#fff',
  title = 'Website',
  score = 5.0
console.log({ color, title, score })

let jedi = 'Grogu'
console.log(`${jedi} será jedi?`)

const price = 300.0
console.log(`El precio de la constante es $${price}`)

console.log(new String('Cadena de texto desde la instancia de la clase String()'))

document.querySelector('#greeting').addEventListener('click', () => {
  // Obtener el nombre desde el navegador
  var name = prompt('Cual es tu nombre?')
  if (name === '' || name === 'null') {
    name = 'mundo'
  }
  const greetings = `Hola, ${name}!`
  alert(greetings)
  document.querySelector('#name').innerHTML = greetings
})

document.querySelector('#calculate').addEventListener('click', () => {
  // Asignando otro tipo de dato a la variable
  let iProduct = 25000
  let discount = 20
  let random = Math.ceil(Math.random() * 30)

  let result = {
    name: 'iProduct',
    price: `$${iProduct} MXN`,
    discount: `$${iProduct * (discount / 100)}`,
    total: `$${iProduct - iProduct * (discount / 100)}`,
    addCost: `$${iProduct * (1 + discount / 100)}`,
    random: random,
    number: random % 2,
  }

  let message = `
        <strong>${result.name}</strong>
        <ul>
            <li>Price: ${result.price}</li>
            <li>${discount}% del iProduct: ${result.discount}</li>
            <li>Restamos el ${discount}% al iProduct: ${result.total}</li>
            <li>Sumamos el ${discount}% del iProduct: ${result.addCost}</li>
            <li>Número aleatorio: ${result.random}</li>
            <li>${result.random} es un número ${result.number == 0 ? 'par' : 'impar'}</li>
        </ul>
    `
  console.log(result)
  document.querySelector('#result').innerHTML = message
})
