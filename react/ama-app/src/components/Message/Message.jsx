import { Card, Elevation } from '@blueprintjs/core'
import React from 'react'

export default function Message ({message}) {
    return (
        <Card elevation={Elevation.FOUR} className='card-question'>
            <input type='hidden' value={message.Id} />
            <h5>{message.Name}</h5>
            <p>{message.Question}</p>
        </Card>
    )
}
