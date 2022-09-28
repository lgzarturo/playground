import { useEffect, useState } from 'react'
import './Countdown.css'

function Countdown () {
    const [target, setTarget] = useState(null)
    const [elapsed, setElapsed] = useState(0)

    useEffect(function () {
        if (target === null) return
        setElapsed(0)
        let interval = setInterval(function () {
            setElapsed((elapsed) => elapsed + 1)
        }, 1000)
        return () => {
            clearInterval(interval)
        }
    }, [target])

    function executeCountdown (ev) {
        ev.preventDefault()
        let seconds = ev.target.seconds.value
        setTarget(parseInt(seconds))
    }

    if (elapsed >= target && target != null) {
        return (
            <>
                <p>¡Se ha terminado el conteo! 🎉</p>
                <button id="countdown" onClick={() => setTarget(null)}>Reiniciar</button>
            </>
        )
    }

    if (target !== null) {
        return (
            <p>Faltan {target - elapsed} segundo</p>
        )
    }

    return (<>
        <p>¿Cuantos segundos quieres contar?</p>
        <form id="countdown" action="#" onSubmit={ev => executeCountdown(ev)}>
            <input type="number" name="seconds" id="seconds" placeholder="Segundos por contar..." />
            <button>Cuenta regresiva</button>
        </form>
    </>)
}

export default Countdown
