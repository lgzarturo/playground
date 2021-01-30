import { User } from './users'
import loggedIn from './loggedIn'

export default function(user: User, formData:{username:string, password:string}) {
    console.log("Login", user, formData)

    if (formData.username === user.username && formData.password === user.password) {
        localStorage.setItem('username', user.username)
        loggedIn()
    } else {
        return
    }
}
