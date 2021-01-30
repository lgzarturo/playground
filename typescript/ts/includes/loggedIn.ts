import { getUsers } from './users'

export default function() {
    console.log(localStorage.username)
    if (localStorage.username) {
        document.getElementById('loginButtonContainer')!.innerHTML = `<span>Hola ${getUsers()[0].username}</span>`
        document.getElementById('addPhotoButtonContainer')!.innerHTML = '<button class="btn btn-primary btn-block">Agregar foto</button>'
    }
}
