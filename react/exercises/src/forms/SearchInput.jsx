import { useContext } from "react"
import { SearchContext } from "../context/SearchContext"

function SearchInput () {
    const {setSearch} = useContext(SearchContext)
    return (
        <input type="text" id="filter" onChange={(event) => setSearch(event.target.value)} />
    )
}

export default SearchInput
