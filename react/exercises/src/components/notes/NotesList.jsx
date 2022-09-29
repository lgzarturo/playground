import { useContext } from "react"
import { NotesContext } from "../../context/NotesContext"
import Note from "./Note"
import NoteForm from "./NoteForm"

function NotesList () {
    const {notes} = useContext(NotesContext)
    return (
        <div className="notes-app">
            <NoteForm />
            <p style={{ textAlign: "right" }}>Tienes { notes.length } notas guardadas</p>
            {notes.map(note => <Note key={note.id} title={note.title} message={note.message} id={note.id} /> )}
        </div>
    )
}

export default NotesList
