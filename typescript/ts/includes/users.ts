export class User {
    constructor(private _username:string, private _password:string) {}

    get username():string {
        return this._username
    }

    set username(username) {
        this._username = username
    }

    get password():string {
        return this._password
    }

    set password(password) {
        this._password = password
    }

}

let users:User[] = []

users.push(new User("arthurolg", "1234"))
users.push(new User("lgzarturo", "secret"))

export function getUsers() {
    return users
}
