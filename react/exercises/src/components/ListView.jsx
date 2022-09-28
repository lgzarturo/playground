import './ListView.css'

function ListView ({ elements, funcFilterItems }) {
    console.log(elements)
    return (
        <div>
            <input type="text" id="filter" onChange={(event) => funcFilterItems(event.target.value)} />
            <ul>
            {
                elements.map((name) => <li key={name}>{name}</li>)
            }
            </ul>
        </div>
    )
}

export default ListView
