import './App.css'
import Countdown from './components/Countdown'
import Counter from './components/Counter'
import PresentationCard from './components/PresentationCard'

function App () {
    return (
        <div className="App">
            <h1>Hola mundo</h1>
            <Countdown />
            <PresentationCard />
            <Counter />
        </div>
    )
}

export default App
