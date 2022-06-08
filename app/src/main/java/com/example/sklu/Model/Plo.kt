package com.example.sklu.Model

class Plo {
    var id = 0
    var name: String? = null
    var fav: String? = null
    var idPerson: String?=null

    constructor() {}

    constructor(name: String, fav: String, idPerson: String) {
        this.name = name
        this.fav = fav
        this.idPerson = idPerson
    }
}