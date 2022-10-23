import {v4 as uuidv4} from 'uuid'

class MessageModel {
  constructor (email, name, question) {
    this._id = uuidv4()
    this._email = email
    this._name = name
    this._question = question
  }

  get Id () {
    return this._id
  }

  set Id (value) {
    this._id = value
  }

  get Email () {
    return this._email
  }
  get Name () {
    return this._name
  }
  get Question () {
    return this._question
  }

  set Email (value) {
    this._email = value
  }
  set Name (value) {
    this._name = value
  }
  set Question (value) {
    this._question = value
  }

  getJson () {
    return JSON.stringify(this)
  }

}

export default MessageModel
