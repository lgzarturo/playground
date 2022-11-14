import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import Card from './components/Card'
import Button from './components/Button'
import CardStyled from './components/CardStyled'
import ButtonStitches from './components/ButtonStitches'

function App () {
    const [count, setCount] = useState(0)

    return (
        <div className="App">
            <Card />
            <Button />
            <CardStyled />
            <ButtonStitches />
        </div>
    )
}

export default App
