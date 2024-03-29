let n = Math.random()

console.log(n)

/* Retorna números aleatorios entre el 1 y el 6 */
n = n * 6
n = Math.floor(n) + 1

console.log(n)

/* Obtener un número aleatorio */
function random (top) {
  return Math.floor(Math.random() * top) + 1
}

console.log(random(10))

/* Generar un número grande de forma aleatoria */
function randomBigNumber () {
  let number = ''
  for (let i = 0; i < 16; i++) {
    number += `${random(9) - 1}`
  }
  return number
}

console.log(`Numero grande aleatorio ${randomBigNumber()}`)

function bmi (weight, height) {
  return Math.round(weight / (height * height))
}
console.log(bmi(84, 1.73))

function leapYear (year) {
  if (year % 4 === 0) {
    if (year % 100 === 0) {
      if (year % 400 == 0) {
        return true
      } else {
        return false
      }
    } else {
      return true
    }
  } else {
    return false
  }
}

function leapYear2 (year) {
  if (year % 4 !== 0) {
    return false
  }
  if (year % 100 === 0 && year % 400 !== 0) {
    return false
  }

  return true
}

console.log(leapYear(2000))
console.log(leapYear(1982))
console.log(leapYear(1752))
console.log('\n')
console.log(leapYear2(2000))
console.log(leapYear2(1982))
console.log(leapYear2(1752))

/* Ejercicio de fizz buzz */
let output = []
let count = 1
function fizzBuzz () {
  let result = ''
  if (count % 3 === 0) {
    result += 'Fizz'
  }

  if (count % 5 === 0) {
    result += 'Buzz'
  }

  if (count % 3 !== 0 && count % 5 !== 0) {
    result = count
  }

  output.push(result)
  count++
}

for (var i = 0; i < 100; i++) {
  fizzBuzz()
}
console.log(output)

/** Ejercicio de números en la secuencia fibonacci */
function fibonacci (n) {
  if (n === 0) {
    return []
  }
  if (n === 1) {
    return [0]
  }
  if (n == 2) {
    return [0, 1]
  }

  let output = [0, 1]
  for (let i = 2; i < n; i++) {
    output.push(output[output.length - 2] + output[output.length - 1])
  }
  return output
}

for (var i = 0; i <= 10; i++) {
  console.log(fibonacci(i))
}
