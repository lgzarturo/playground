import { FormGroup, InputGroup, Intent } from '@blueprintjs/core'
import React, { useState } from 'react'

export default function NameInput ({name, setName, nameInputRef}) {
    return (
        <>
            <FormGroup
                helperText="Escribe tu nombre..."
                label="Nombre completo"
                labelFor="name"
                labelInfo="(requerido)"
            >
                <InputGroup
                    id="name"
                    placeholder="Ej. John Doe"
                    value={name}
                    ref={nameInputRef}
                    intent={Intent.PRIMARY}
                    onChange={(e) => setName(e.target.value)} />
            </FormGroup>
        </>
    )
}
