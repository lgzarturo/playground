import { useContext } from "react"
import { ItemsContext } from "../context/ItemsContext"
import { SearchContext } from "../context/SearchContext"

function ResultsCount () {
    const elements = useContext(ItemsContext)
    const { search } = useContext(SearchContext)
    const items = elements.filter(el => !!el).length
    return (
        <p>
            {items ? `Se encontraron ${items} elementos` : 'No se encontraron elementos'}
            {search && ` para la búsqueda '${search}'`}
        </p>
    )
}

export default ResultsCount
