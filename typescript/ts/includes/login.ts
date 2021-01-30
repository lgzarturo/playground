import { User } from './users'

export default function(user: User, formData:{username:string, password:string}) {
    console.log("Login", user, formData)
}
