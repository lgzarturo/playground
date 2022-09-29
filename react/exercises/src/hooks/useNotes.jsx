import { useEffect, useState } from "react"

const LOCAL_STORAGE_KEY = "MY_NOTES.list"

function useNotes () {
    const [notes, setNotes] = useState([])

    useEffect(() => {
        let savedNotes = localStorage.getItem(LOCAL_STORAGE_KEY)
        if (savedNotes) {
            setNotes(JSON.parse(savedNotes))
        }
    }, [])

    useEffect(() => {
        if (!notes || notes.length === 0) return
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(notes))
    }, [notes])

    const add = (title, message) => {
        const id = Date.now()
        const noteObject = {
            id, title, message
        }
        setNotes([noteObject, ...notes])
    }

    const remove = (id) => {
        let updatedNotes = notes.filter(note => note.id !== id)
        setNotes(updatedNotes)
    }

    return { notes, add, remove }
}

export default useNotes
