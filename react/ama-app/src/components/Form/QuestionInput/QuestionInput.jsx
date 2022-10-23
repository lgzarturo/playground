import { Label, TextArea, Intent } from '@blueprintjs/core'
import React, { useState } from 'react'

export default function QuestionInput ({ question, setQuestion }) {
    return (
        <>
            <Label htmlFor='question'>Pregunta <span className="bp4-text-muted">(requerido)</span></Label>
            <TextArea
                id='question'
                large={true}
                value={question}
                fill={true}
                growVertically={true}
                intent={Intent.PRIMARY}
                placeholder="Escribe tu pregunta"
                onChange={(e) => setQuestion(e.target.value)}
            />
        </>
    )
}
