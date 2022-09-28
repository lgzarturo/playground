import './PresentationCard.css'
import imageLogo from '../assets/cover-back.jpg'

function PresentationCard () {
    let name = 'Arturo'
    return (
        <div className='presentation-card'>
            <img src={imageLogo} className='avatar' alt='Avatar' />
            <h1>Hola soy {name} y estoy aprendiendo React</h1>
        </div>
    )
}

export default PresentationCard
