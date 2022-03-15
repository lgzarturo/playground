const ratingContainer = document.querySelector('.rating')
const limit = 10
let currentValue = 1

const html = Array.from(Array(limit)).map((_, i) => {
  const active = i < currentValue
  return `
    <span class="item item-${i}${active ? ' active' : ''}" data-pos="${i}">
      <i class="fas fa-star"></i>
    </span>
  `
})

ratingContainer.innerHTML = html.join('')

document.querySelectorAll('.item').forEach(item => {
  item.addEventListener('mouseover', e => {
    const pos = item.getAttribute('data-pos')
    if (currentValue === parseInt(pos) + 1) return
    document.querySelectorAll('.item').forEach(item => {
      if (item.classList.contains('active')) {
        item.classList.remove('active')
      }
    })
    for (let i = 0; i <= pos; i++) {
      const item = document.querySelector(`.item-${i}`)
      if (!item.classList.contains('active')) {
        item.classList.add('active')
      }
    }
    currentValue = parseInt(pos) + 1
  })

  item.addEventListener('click', e => {
    currentValue = parseInt(item.getAttribute('data-pos')) + 1
    console.log(`You have rated ${currentValue} stars`)
  })
})
