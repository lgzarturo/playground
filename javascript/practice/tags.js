let tags = []

const inputTagContainer = document.querySelector('#inputTag')
const tagsContainer = document.createElement('div')
const inputTag = document.createElement('span')

inputTag.ariaRoleDescription = 'textbox'
inputTag.contentEditable = 'true'
inputTag.classList.add('input')
inputTag.focus()

inputTagContainer.classList.add('inputTagContainer')
tagsContainer.classList.add('tagContainer')
inputTagContainer.appendChild(tagsContainer)
tagsContainer.appendChild(inputTag)

inputTagContainer.addEventListener('click', e => {
  if (e.target.id === 'inputTag' || e.target.classList.contains('tagContainer')) {
    inputTag.focus()
  }
})

inputTag.addEventListener('keydown', e => {
  if (e.key === 'Enter' && inputTag.textContent !== '') {
    e.preventDefault()
    if (!existTag(inputTag.textContent)) {
      tags.push(inputTag.textContent)
      inputTag.textContent = ''
    }
    renderTags()
  } else if (e.key === 'Backspace' && inputTag.textContent === '' && tags.length > 0) {
    tags.pop()
    renderTags()
  }
})

function renderTags () {
  tagsContainer.innerHTML = ''
  const html = tags.map(tag => {
    const tagElement = document.createElement('div')
    const tagButton = document.createElement('button')
    tagElement.classList.add('tag')
    tagButton.textContent = 'X'
    tagButton.addEventListener('click', (e) => {
      removeTag(tag)
      renderTags()
    })
    tagElement.appendChild(document.createTextNode(tag))
    tagElement.appendChild(tagButton)
    return tagElement
  })

  html.forEach(element => {
    tagsContainer.appendChild(element)
  })
  tagsContainer.appendChild(inputTag)
  inputTag.focus()
}

function existTag (value) {
  return tags.includes(value)
}

function removeTag (value) {
  tags = tags.filter(tag => tag !== value)
  renderTags()
}
