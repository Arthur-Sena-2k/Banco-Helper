package com.example.manager

import java.text.SimpleDateFormat

class Pessoa {
    var id: Int
    var nome: String
    var idade: Int
    var created_at: Int
    var updated_at: Int


    //vem da memória
    constructor(nome: String, idade: Int) {
        this.id = -1
        this.nome = nome
        this.idade = idade
        this.created_at = -1
        this.updated_at = -1
    }

    constructor(id: Int, nome: String, idade: Int, created_at: Int, updated_at: Int) {
        this.id = id
        this.nome = nome
        this.idade = idade
        this.created_at = created_at
        this.updated_at = updated_at
    }

    override fun toString(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        return "${id} ${nome} ${idade} + ${sdf.format(created_at)} ${sdf.format(updated_at)}"
    }
}