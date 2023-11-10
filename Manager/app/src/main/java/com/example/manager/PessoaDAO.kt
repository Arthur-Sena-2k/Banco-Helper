package com.example.manager

import android.content.ContentValues
import android.content.Context
import java.util.Calendar

class PessoaDAO {

    private val banco: BancoHelper

    constructor(context: Context) {
        this.banco = BancoHelper(context)
    }

    fun insert (pessoa: Pessoa) {
        val dataHora = Calendar.getInstance().timeInMillis
        val cv = ContentValues()
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        cv.put("created_at", dataHora)
        cv.put("updated_at", dataHora)
        this.banco.writableDatabase.insert("pessoas", null, cv)
    }

    fun select(): List<Pessoa> {
        var lista = ArrayList<Pessoa>()
        val colunas = arrayOf("id", "nome", "idade", "created_at", "updated_at")
        val c = this.banco.readableDatabase.query("pessoas", colunas, null, null, null, null, null)

        c.moveToFirst()
        for (i in 1..c.count) {
            val id = c.getInt(0)
            val nome = c.getString(1)
            val idade = c.getInt(2)
            val created_at = c.getInt(3)
            val updated_at = c.getInt(4)
            val pessoa = Pessoa(id, nome, idade, created_at, updated_at)
            lista.add(pessoa)
            c.moveToNext()
        }

        return lista
    }

    fun find(id: Int): Pessoa? {
        return null
    }

    fun delete (id: Int) {

    }

    fun update(pessoa: Pessoa) {

    }

}