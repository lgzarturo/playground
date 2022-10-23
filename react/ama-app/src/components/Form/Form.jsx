import { Button, Label } from '@blueprintjs/core'
import React, { createRef, useState, forwardRef } from 'react'
import MessageModel from '../../models/MessageModel'
import NameInput from './NameInput/NameInput'
import QuestionInput from './QuestionInput/QuestionInput'

const EmailInput = forwardRef((props, ref) => (
    <input ref={ref} {...props} type="email" className="bp4-input bp4-fill" />
))

const validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
            /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        )
}

export default function Form ({ setMessages }) {
    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [question, setQuestion] = useState("")
    const nameInputRef = createRef()
    const dataName = { name, setName }
    const dataQuestion = { question, setQuestion }
    const emailRef = createRef()

    function handleSubmit () {
        const errors = []
        if (email === "") {
            errors.push("El correo es un campo requerido")
            emailRef.current.focus()
            emailRef.current.classList.add('bp4-intent-danger')
        } else if (!validateEmail(email)) {
            errors.push('El correo electrónico no es valido')
        }

        if (name === "") {
            errors.push("Se necesita un nombre")
        }

        if (question === "") {
            errors.push("Especifique su pregunta")
        }

        if (errors.length > 0) {
            alert(errors.join("\n"))
            return
        }

        const dataQuestion = new MessageModel(email, name, question)
        const persistedQuestions = window.localStorage.getItem('questions')
        let messages = []
        if (persistedQuestions) {
            const listJsonMessages = JSON.parse(persistedQuestions)
            listJsonMessages.forEach(message => {
                let messageModel = new MessageModel(message._email, message._name, message._question)
                messageModel.Id = message._id
                messages.push(messageModel)
            })
        }
        messages = [...messages, dataQuestion]
        const items = messages.map(item => item.getJson())
        window.localStorage.setItem('questions', `[${items}]`)
        setMessages(messages)
        setName('')
        setQuestion('')
    }

    function handleEmailChange (event) {
        if (event.target.value === '') {
            emailRef.current.classList.add('bp4-intent-danger')
        } else {
            emailRef.current.classList.remove('bp4-intent-danger')
        }
        setEmail(event.target.value)
    }

    return (
        <>
            <Label htmlFor='email'>Correo electrónico <span className="bp4-text-muted">(requerido)</span></Label>
            <EmailInput name='email' ref={emailRef} value={email} onChange={handleEmailChange} style={{ marginBottom: '1rem' }} placeholder='email@domain.com' />
            <NameInput {...dataName} nameInputRef={nameInputRef} />
            <QuestionInput {...dataQuestion} />
            <div className='buttons'>
                <Button fill={true} text='Guardar' className='bp4-large' onClick={() => handleSubmit()} />
            </div>
        </>
    )
}
