import { useContext } from "react"
import { NotesContext } from "../../context/NotesContext"

import './NoteDeleteButton.css'

function NoteDeleteButton ({ id }) {
    const {remove} = useContext(NotesContext)
    return (
        <button className="delete" onClick={ev => remove(id)}>X</button>
    )
}

export default NoteDeleteButton
