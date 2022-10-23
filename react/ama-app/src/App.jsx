import './App.css'
import { Card, Elevation, NonIdealState } from '@blueprintjs/core'
import Form from './components/Form/Form'
import Message from './components/Message/Message'
import MessageModel from './models/MessageModel'
import { useEffect, useState } from 'react'

function App () {
    const [messages, setMessages] = useState([])

    useEffect(() => {
        console.log("Initializing component..")
        const persistedQuestions = window.localStorage.getItem('questions')
        const items = []
        if (persistedQuestions) {
            const listJsonMessages = JSON.parse(persistedQuestions)
            listJsonMessages.forEach(message => {
                let messageModel = new MessageModel(message._email, message._name, message._question)
                messageModel.Id = message._id
                items.push(messageModel)
            })
            setMessages(items)
        }
    }, [])

    return (
        <div className="App">
            <Card elevation={Elevation.FOUR}>
                <Form setMessages={setMessages} />
            </Card>
            <br />
            {messages.length === 0 && (
                <NonIdealState
                    icon='hand-down'
                    title='No hay preguntas'
                    description='Escribe tu pregunta en el formulario' />
            )}
            {messages.length > 0 && (messages.map(message => (<Message key={message.Id} message={message} />)))}
        </div>
    )
}

export default App
