/*
Escribe una función que al recibir un número:
- Muestre "fizz" si es múltiplo de 3
- Muestre "buzz" si es múltiplo de 5
- Muestre "fizz buzz" si es múltiplo de 3 y 5
- Muestra el número si no es múltiplo de ninguno de los anteriores.
*/
export const fizzBuzz = (number) => {
  if (typeof number !== 'number') throw new Error('Parameter provided must be a number')
  if (Number.isNaN(number)) throw new Error('Parameter provided must be a number')

  const multiplies = { 3: 'fizz', 5: 'buzz' }
  let output = ''

  Object.entries(multiplies)
    .forEach(([multiplier, word]) => {
      if (number % multiplier === 0) output += word
    })

  return output === '' ? number : output
}
