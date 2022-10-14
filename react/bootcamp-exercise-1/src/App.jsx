import './App.css'
import Portrait from './components/Portrait/Portrait'
import Hello from './components/Hello/Hello'
import Footer from './components/Footer/Footer'
import Welcome from "./components/Welcome/Welcome";

function App() {
    return (
        <div className="card">
            <Welcome/>
            <div class="card-header">
                <Hello name="Arturo"/>
            </div>
            <div class="card-body">
                <Portrait/>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <Hello name="Arturo"/>
            </div>
            <div class="card-footer text-muted">
                <Footer/>
            </div>
        </div>
    )
}

export default App
