import NoteDeleteButton from "./NoteDeleteButton"

function Note ({ id, title, message }) {

    return (
        <div className="note">
            <NoteDeleteButton id={id} />
            <h2>{title}</h2>
            <p>{message}</p>
        </div>
    )
}

export default Note
