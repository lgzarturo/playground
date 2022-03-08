const number = document.querySelector('#card-number')
const expiry = document.querySelector('#card-expiry')
const cvc = document.querySelector('#card-cvc')

const maskNumber = '####-####-####-####'
const maskExpiry = '##/##'
const maskCvc = '###'
const maskCvcAmex = '####'

const cardNumber = []
const cardExpiry = []
const cardCvc = []

number.addEventListener('keydown', e => {
  if (e.key === 'Tab') {
    return
  }
  e.preventDefault()
  handleInput(e.key, maskNumber, cardNumber)
  number.value = cardNumber.join('')
})

expiry.addEventListener('keydown', e => {
  if (e.key === 'Tab') {
    return
  }
  e.preventDefault()
  handleInput(e.key, maskExpiry, cardExpiry)
  expiry.value = cardExpiry.join('')
})

cvc.addEventListener('keydown', e => {
  if (e.key === 'Tab') {
    return
  }
  e.preventDefault()
  const mask = number.value.startsWith('34') || number.value.startsWith('37') ? maskCvcAmex : maskCvc
  handleInput(e.key, mask, cardCvc)
  cvc.value = cardCvc.join('')
})

function handleInput (key, mask, arr) {
  const number = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
  if ((key === 'Backspace' || key === 'Delete') && arr.length > 0) {
    arr.pop()
    return
  }
  if (number.includes(key) && arr.length + 1 <= mask.length) {
    if (mask[arr.length] === '-' || mask[arr.length] === '/') {
      arr.push(mask[arr.length], key)
    } else {
      arr.push(key)
    }
  }
}
