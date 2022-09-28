import SearchInput from '../forms/SearchInput'
import './ListView.css'

function ListView ({ elements }) {
    console.log(elements)
    return (
        <div>
            <SearchInput />
            <ul>
            {
                elements.map((name, index) => name && <li key={index}>{name}</li>)
            }
            </ul>
        </div>
    )
}

export default ListView
