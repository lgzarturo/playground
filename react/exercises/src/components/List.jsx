import { useState } from 'react'
import SearchContext from '../context/SearchContext'
import frameworks from './items'

import ListView from './ListView'

function List () {
    const [items, setItems] = useState(frameworks)

    function filterItems (pattern) {
        if (pattern === "") setItems(frameworks)
        setItems(filterItemsBySearchPattern(pattern))
    }

    function filterItemsBySearchPattern (pattern) {
        const filterItems = frameworks
            .map(item => item.toLowerCase().includes(pattern.toLowerCase()) ? item : null)
        return filterItems
    }

    return (
        <SearchContext.Provider value={{funcFilterItems: filterItems}}>
            <ListView elements={items} />
        </SearchContext.Provider>
    )
}

export default List
