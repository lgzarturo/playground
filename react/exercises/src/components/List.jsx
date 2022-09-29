import { ItemsProvider } from '../context/ItemsContext'
import { SearchProvider } from '../context/SearchContext'
import ListView from './ListView'
import ResultsCount from './ResultsCount'

function List () {
    return (
        <SearchProvider>
            <ItemsProvider>
                <ListView />
                <ResultsCount />
            </ItemsProvider>
        </SearchProvider>
    )
}

export default List
