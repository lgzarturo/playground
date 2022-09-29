import { useContext } from 'react'
import { ItemsContext } from '../context/ItemsContext'
import SearchInput from '../forms/SearchInput'
import './ListView.css'

function ListView () {
    const elements = useContext(ItemsContext)
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
