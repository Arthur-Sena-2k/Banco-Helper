package com.example.manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var dao: PessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = PessoaDAO(this)

        this.dao.insert(Pessoa("primeiro", 10))
        Log.i("APP_MANAGER", this.dao.select().toString())


    }
}