package com.example.sklu.Model

class Person {
    var id = 0
    var name: String? = null
    var email: String? = null
    var password: String? = null
    var role: String? = null

    fun detail():String{
        return " name:${this.name}  email: ${this.email}  pass:${this.password} role:${this.role}"
    }

    constructor() {}
    constructor(email: String, pass:String) {
        this.email = email
        this.password = pass
    }
    constructor(id: Int, name: String?, role: String?, email: String?, password: String?) {
        this.id = id
        this.name = name
        this.role = role
        this.email = email
        this.password = password
    }

    constructor(name: String?, role: String?, email: String?, password: String?) {
        this.name = name
        this.role = role
        this.email = email
        this.password = password
    }
}