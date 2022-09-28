import { useState } from 'react'
import frameworks from './items'

import ListView from './ListView'

function List () {
    const [items, setItems] = useState(frameworks)

    function filterItems (pattern) {
        if (pattern === "") setItems(frameworks)
        setItems(filterItemsBySearchPattern(pattern))
    }

    function filterItemsBySearchPattern (pattern) {
        const filterItems = frameworks.filter(item => item.toLowerCase().includes(pattern.toLowerCase()))
        return filterItems
    }

    return (
        <div>
            <ListView elements={items} funcFilterItems={filterItems} />
        </div>
    )
}

export default List
