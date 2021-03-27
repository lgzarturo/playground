/*
Código de JavaScript básico
*/
console.log('Enlazando archivo externo')

/*
Variables
*/

// Asignando un valor a la variable
let iProduct = 'iPhone 12'
console.log(iProduct)

// Cambiando el valor de la variable
iProduct = 'iMac'
console.log(iProduct)

// Iniciar una variable sin valor
let isActive
isActive = false
// eslint-disable-next-line no-unused-vars
isActive = true

// Iniciar multiples variables
const color = '#fff'
const title = 'Website'
const score = 5.0
console.log({ color, title, score })

const jedi = 'Grogu'
console.log(`${jedi} será jedi?`)

const price = 300.0
console.log(`El precio de la constante es $${price}`)

console.log('Cadena de texto desde la instancia de la clase String()')

document.querySelector('#greeting').addEventListener('click', () => {
  // Obtener el nombre desde el navegador
  let name = prompt('Cual es tu nombre?')
  if (name === '' || name === 'null') {
    name = 'mundo'
  }
  const greetings = `Hola, ${name}!`
  alert(greetings)
  document.querySelector('#name').innerHTML = greetings
})

document.querySelector('#calculate').addEventListener('click', () => {
  // Asignando otro tipo de dato a la variable
  const iProduct = 25000
  const discount = 20
  const random = Math.ceil(Math.random() * 30)

  const result = {
    name: 'iProduct',
    price: `$${iProduct} MXN`,
    discount: `$${iProduct * (discount / 100)}`,
    total: `$${iProduct - iProduct * (discount / 100)}`,
    addCost: `$${iProduct * (1 + discount / 100)}`,
    random: random,
    number: random % 2,
  }

  const message = `
        <strong>${result.name}</strong>
        <ul>
            <li>Price: ${result.price}</li>
            <li>${discount}% del iProduct: ${result.discount}</li>
            <li>Restamos el ${discount}% al iProduct: ${result.total}</li>
            <li>Sumamos el ${discount}% del iProduct: ${result.addCost}</li>
            <li>Número aleatorio: ${result.random}</li>
            <li>${result.random} es un número ${result.number === 0 ? 'par' : 'impar'}</li>
        </ul>
    `
  console.log(result)
  document.querySelector('#result').innerHTML = message
})
