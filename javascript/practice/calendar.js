let events = []

const eventName = document.querySelector('#event')
const eventDate = document.querySelector('#date')
const eventsContainer = document.querySelector('#events')
const form = document.querySelector('#form')

form.addEventListener('submit', e => {
  e.preventDefault()
  addEvent()
})

function addEvent () {
  if (eventName.value === '' || eventDate.value === '') {
    return
  }

  if (dateDiff(eventDate.value) < 0) {
    return
  }

  const newEvent = {
    id: (Math.random() * 100).toString(36).slice(3),
    name: eventName.value,
    date: eventDate.value
  }

  events.unshift(newEvent)
  eventName.value = ''
  renderEvents()
}

function dateDiff (date) {
  const now = new Date()
  const event = new Date(date)
  const diff = event.getTime() - now.getTime()
  const days = Math.ceil(diff / (1000 * 60 * 60 * 24))
  return days
}

function renderEvents () {
  const html = events.map(event => {
    const days = dateDiff(event.date)
    const daysLabel = days > 1 ? 'days' : 'day'
    return `
      <li class="event">
        <div class="days">${days} ${daysLabel}</div>
        <div class="name">${event.name}</div>
        <div class="date">${event.date}</div>
        <div class="actions">
          <button class="delete" data-id="${event.id}">Delete</button>
        </div>
      </li>
    `
  })
  eventsContainer.innerHTML = html.join('')
  const deleteButtons = document.querySelectorAll('.event .delete')
  deleteButtons.forEach(button => {
    button.addEventListener('click', e => {
      const id = button.getAttribute('data-id')
      deleteEvent(id)
      renderEvents()
    })
  })
}

function deleteEvent (id) {
  events = events.filter(event => event.id !== id)
}

function save() {}
