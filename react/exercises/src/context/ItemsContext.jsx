import { createContext, useContext, useEffect, useState } from "react"
import frameworks from "../components/items"
import { SearchContext } from "./SearchContext"

export const ItemsContext = createContext([])

export function ItemsProvider ({ children }) {

    const [items, setItems] = useState(frameworks)
    let { search } = useContext(SearchContext)

    useEffect(function () {
        if (!search || search === "") {
            setItems(frameworks)
            return
        }
        filterItems(search)
    }, [search])

    function filterItems (pattern) {
        setItems(filterItemsBySearchPattern(pattern))
    }

    function filterItemsBySearchPattern (pattern) {
        const filterItems = frameworks
            .map(item => item.toLowerCase().includes(pattern.toLowerCase()) ? item : null)
        return filterItems
    }

    return (
        <ItemsContext.Provider value={items}>
            {children}
        </ItemsContext.Provider>
    )
}
