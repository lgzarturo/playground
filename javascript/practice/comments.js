const comments = []
const inputContainer = document.createElement('div')
const input = document.createElement('input')
const commentsContainer = document.querySelector('#commentsContainer')
input.classList.add('input')

input.classList.add('input')

input.addEventListener('keydown', (e) => {
  handleEnter(e, null)
})

commentsContainer.appendChild(inputContainer)
inputContainer.appendChild(input)

function handleEnter (e, current) {
  if (e.key === 'Enter' && e.target.value !== '') {
    const comment = {
      text: e.target.value,
      likes: 0,
      responses: []
    }
    if (current === null) {
      comments.unshift(comment)
    } else {
      current.responses.unshift(comment)
    }

    e.target.value = ''
    commentsContainer.innerHTML = ''
    commentsContainer.appendChild(inputContainer)
    renderComments(comments, commentsContainer)
  }
}

function renderComments (arr, parent) {
  arr.forEach((comment) => {
    const commentContainer = document.createElement('div')
    commentContainer.classList.add('commentContainer')
    const responsesContainer = document.createElement('div')
    responsesContainer.classList.add('responsesContainer')

    const replyButton = document.createElement('button')
    const likeButton = document.createElement('button')

    const actionsContainer = document.createElement('div')
    const textContainer = document.createElement('div')
    textContainer.textContent = comment.text

    replyButton.textContent = 'Reply'
    likeButton.textContent = `${comment.likes > 0 ? `${comment.likes} likes` : 'like'}`
    replyButton.addEventListener('click', () => {
      const newInput = inputContainer.cloneNode(true)
      newInput.value = ''
      newInput.focus()
      newInput.addEventListener('keydown', (e) => {
        handleEnter(e, comment)
      })
      commentContainer.insertBefore(newInput, responsesContainer)
    })
    likeButton.addEventListener('click', () => {
      comment.likes++
      likeButton.textContent = `${comment.likes > 0 ? `${comment.likes} likes` : 'like'}`
    })

    commentContainer.appendChild(textContainer)
    commentContainer.appendChild(actionsContainer)
    actionsContainer.appendChild(replyButton)
    actionsContainer.appendChild(likeButton)
    commentContainer.appendChild(responsesContainer)

    if (comment.responses.length > 0) {
      renderComments(comment.responses, responsesContainer)
    }
    parent.appendChild(commentContainer)
  })
}
