import React from 'react'
import './styles.css'

const BASE_URL = 'https://jsonplaceholder.typicode.com'

export default function Card () {
    const [posts, setPosts] = React.useState([])
    const [title, setTitle] = React.useState('')
    const [body, setBody] = React.useState('')
    const [isLoading, setIsLoading] = React.useState(false)

    async function loadPosts (event) {
        try {
            const response = await fetch(`${BASE_URL}/posts`)
            if (response.status === 200) {
                const response_json = await response.json()
                console.log('ejemplo', response_json)
                setPosts(response_json)
            } else {
                throw new Error(`Respuesta fetch ${response.status}`)
            }
        } catch (error) {
            console.log('Se presento un problema con el servidor')
            console.error(error)
        }
    }

    async function createPost (event) {
        event.preventDefault()
        setIsLoading(true)
        console.log({ title, body })
        try {
            const response = await fetch(`${BASE_URL}/posts`, {
                method: 'POST',
                body: JSON.stringify({ title, body, userId: 1 }),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8'
                }
            })
            const data = await response.json()
            console.log(data)
            setTitle('')
            setBody('')
        } catch (error) {
            console.log('Se presento un problema con el servidor')
            console.error(error)
        }
        setIsLoading(false)
    }

    React.useEffect(() => {
        loadPosts()
    }, [])

    return (
        <div className="card">
            <h4 className="card-title">Card</h4>
            <form onSubmit={createPost}>
                <p>
                    <label htmlFor="title">Titulo</label><br />
                    <input type="text" name='title' onChange={(event) => setTitle(event.target.value)} />
                </p>
                <p>
                    <label htmlFor="body">Contenido</label><br />
                    <textarea name="body" cols="30" rows="10" onChange={(event) => setBody(event.target.value)}></textarea>
                </p>
                <button type='submit' disabled={isLoading}>Enviar</button>
            </form>
            <ul>
                {posts.map((post) => (<li key={post.id}>{post.title}</li>))}
            </ul>
        </div>
    )
}
