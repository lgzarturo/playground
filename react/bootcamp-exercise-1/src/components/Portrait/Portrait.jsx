import "./Portrait.css"
import portrait from '../../assets/rick-and-morty.jpg'

export default function Portrait () {
    return (
        <>
            <img src={portrait} className="card-img-top" alt="Rick and morty" />
        </>
    )
}
