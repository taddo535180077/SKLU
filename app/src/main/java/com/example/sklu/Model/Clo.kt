package com.example.sklu.Model

class Clo {
    var id = 0
    var name: String? = null
    var score: String? = null
    var status: String? = null
    var grade: String? = null
    var idPerson: String?=null
    var username: String?=null

    var list: String? = null

    constructor() {}

    constructor(name: String, score: String, grade: String,list: String, idPerson: String, username: String) {
        this.name = name
        this.score = score
        this.grade = grade
        this.list = list
        this.idPerson = idPerson
        this.username = username
    }
    constructor(id: Int, name: String, score: String, status: String) {
        this.name = name
        this.score = score
        this.status = status
        this.id = id
    }



}