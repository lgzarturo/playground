import './Counter.css'
import { useState } from "react"

function Counter () {
    const [counter, setCounter] = useState(0)
    return (
        <>
            <p>Has hecho clic <span>{counter}</span> veces en el botón</p>
            <button onClick={() => setCounter(counter + 1)}>Incrementar</button>
        </>
    )
}

export default Counter
