const keys = [
  [
    ['`', '~'],
    ['1', '!'],
    ['2', '@'],
    ['3', '#'],
    ['4', '$'],
    ['5', '%'],
    ['6', '^'],
    ['7', '&'],
    ['8', '*'],
    ['9', '('],
    ['0', ')'],
    ['-', '_'],
    ['=', '+'],
    ['Backspace', 'Backspace']
  ],
  [
    ['Tab', 'Tab'],
    ['q', 'Q'],
    ['w', 'W'],
    ['e', 'E'],
    ['r', 'R'],
    ['t', 'T'],
    ['y', 'Y'],
    ['u', 'U'],
    ['i', 'I'],
    ['o', 'O'],
    ['p', 'P'],
    ['[', '{'],
    [']', '}'],
    ['\\', '|']
  ],
  [
    ['Caps Lock', 'Caps Lock'],
    ['a', 'A'],
    ['s', 'S'],
    ['d', 'D'],
    ['f', 'F'],
    ['g', 'G'],
    ['h', 'H'],
    ['j', 'J'],
    ['k', 'K'],
    ['l', 'L'],
    [';', ':'],
    ["'", '"'],
    ['Enter', 'Enter']
  ],
  [
    ['Shift', 'Shift'],
    ['z', 'Z'],
    ['x', 'X'],
    ['c', 'C'],
    ['v', 'V'],
    ['b', 'B'],
    ['n', 'N'],
    ['m', 'M'],
    [',', '<'],
    ['.', '>'],
    ['/', '?'],
    ['Shift', 'Shift']
  ],
  [
    ['Ctrl', 'Ctrl'],
    ['Alt', 'Alt'],
    ['Win', 'Win'],
    ['Space', 'Space'],
    ['Alt', 'Alt'],
    ['Ctrl', 'Ctrl']
  ]
]

let mayus = false
let shift = false
let current = null

function render () {
  const keyboardContainer = document.querySelector('#keyboard')
  const empty = '<div class="key-empty"></div>'
  const layers = keys.map(layer => {
    return layer.map(key => {
      if (key[0] === 'Shift') {
        return `<button class="key key-shift">${key[0]}</button>`
      }
      if (key[0] === 'Caps Lock') {
        return `<button class="key key-caps">${key[0]}</button>`
      }
      if (key[0] === 'Ctrl') {
        return `<button class="key key-ctrl">${key[0]}</button>`
      }
      if (key[0] === 'Alt') {
        return `<button class="key key-alt">${key[0]}</button>`
      }
      if (key[0] === 'Win') {
        return `<button class="key key-win">${key[0]}</button>`
      }
      if (key[0] === 'Space') {
        return `<button class="key key-space">${key[0]}</button>`
      }
      if (key[0] === 'Backspace') {
        return `<button class="key key-backspace">${key[0]}</button>`
      }
      return `<button class="key key-simple">${shift ? key[1] : mayus && key[0].toLowerCase().charCodeAt(0) >= 97 && key[0].toLowerCase().charCodeAt(0) <= 122 ? key[1] : key[0]}</button>`
    })
  })
  layers[0].push(empty)
  layers[1].unshift(empty)
  const html = layers.map(layer => {
    return `<div class="keyboard-layer">${layer.join('')}</div>`
  })
  let keysHtml = ''
  html.forEach(layer => {
    keysHtml += `<div class="keyboard-row">${layer}</div>`
  })

  keyboardContainer.innerHTML = `<div class='keyboard-wrapper'>${keysHtml}</div>`
  document.querySelectorAll('.key').forEach(key => {
    key.addEventListener('click', () => {
      const keyText = key.textContent
      if (current) {
        if (keyText === 'Caps Lock') {
          mayus = !mayus
        } else if (keyText === 'Shift') {
          shift = !shift
        } else if (keyText === 'Space') {
          current.value += ' '
        } else {
          current.value += key.textContent.trim()
          if (shift) {
            shift = false
          }
        }
        render()
        current.focus()
      }
    })
  })
}

render()

document.querySelectorAll('input').forEach(input => {
  input.addEventListener('focusin', e => {
    current = e.target
  })
})
