import './App.css'
import Countdown from './components/Countdown'
import Counter from './components/Counter'
import List from './components/List'
import PresentationCard from './components/PresentationCard'
import TooltipText from './components/TooltipText'
import AppForm from './forms/AppForm'

function App () {
    return (
        <div className="App">
            <h1>Hola mundo</h1>
            <Countdown />
            <PresentationCard />
            <Counter />
            <List />
            <p><TooltipText tooltip={"Lorem ipsum dolor"}>Lorem ipsum dolor</TooltipText> sit amet consectetur adipisicing elit. Culpa officiis in eius veritatis minus, expedita fugiat hic voluptatum quasi pariatur ipsa necessitatibus vel placeat temporibus. Commodi dolore hic officia qui!</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit praesentium atque aspernatur numquam <TooltipText tooltip={"obcaecati perferendis"}>obcaecati perferendis</TooltipText> ullam ipsum error fugiat distinctio, eum veritatis, voluptatibus esse repellendus possimus quibusdam voluptates neque quas.</p>
            <AppForm />
        </div>
    )
}

export default App
