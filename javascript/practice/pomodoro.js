const tasks = []
const MAX_TASK_BREAK_LENGTH = 5 * 60
const MAX_TASK_TIMER_LENGTH = 25 * 60
let time = 0
let timer = null
let timerBreak = null

const task = document.querySelector('#task')
const form = document.querySelector('#form')
const taskName = document.querySelector('#time #taskName')

renderTime()
renderTasks()

form.addEventListener('submit', e => {
  e.preventDefault()
  if (task.value !== '') {
    createTask(task.value)
    task.value = ''
    renderTasks()
  }
})

function createTask (value) {
  const newTask = {
    id: (Math.random() * 100).toString(36).slice(3),
    title: value,
    completed: false,
    wip: false
  }

  tasks.unshift(newTask)
}

function renderTasks () {
  const html = tasks.map(task => {
    const disabled = task.wip ? 'disabled' : ''
    return `
      <li class="task">
        <input type="checkbox" id="${task.id}" ${task.completed ? 'checked' : ''} disabled>
        <label for="${task.id}" class="${task.completed ? 'done' : 'wip'}">${task.title}</label>
        <button class="delete" data-id="${task.id}" ${disabled}>X</button>
        ${task.completed ? `<button class="undo" data-id="${task.id}" ${disabled}>Undo</button>` : `<button class="start" data-id="${task.id}" ${disabled}>${task.wip ? 'In progress...' : 'Start'}</button>`}
      </li>
    `
  })
  const tasksContainer = document.querySelector('#tasks')
  tasksContainer.innerHTML = html.join('')
  const startButtons = document.querySelectorAll('.task .start')
  startButtons.forEach(button => {
    button.addEventListener('click', e => {
      if (!timer) {
        const id = button.getAttribute('data-id')
        button.textContent = 'In progress...'
        startButtonHandler(id)
      }
      renderTasks()
    })
  })
}

function startButtonHandler (id) {
  time = MAX_TASK_TIMER_LENGTH
  const task = tasks.find(task => task.id === id)
  taskName.textContent = task.title
  renderTime()
  task.wip = true
  timer = setInterval(() => { timeHandler(id) }, 1000)
}

function timeHandler (id) {
  time--
  renderTime()
  if (time === 0) {
    clearInterval(timer)
    markCompleted(id)
    timer = null
    renderTasks()
    startBreak()
  }
}

function renderTime () {
  const timeContainer = document.querySelector('#time #value')
  const minutes = parseInt(time / 60)
  const seconds = parseInt(time % 60)
  timeContainer.textContent = `${minutes < 10 ? '0' : ''}${minutes}:${seconds < 10 ? '0' : ''}${seconds}`
}

function markCompleted (id) {
  const task = tasks.find(task => task.id === id)
  task.wip = false
  task.completed = true
}

function startBreak () {
  time = MAX_TASK_BREAK_LENGTH
  taskName.textContent = 'Break'
  renderTime()
  timerBreak = setInterval(() => { timeHandlerBreak() }, 1000)
}

function timeHandlerBreak () {
  time--
  renderTime()
  if (time === 0) {
    clearInterval(timerBreak)
    timerBreak = null
    taskName.textContent = ''
    renderTasks()
  }
}
