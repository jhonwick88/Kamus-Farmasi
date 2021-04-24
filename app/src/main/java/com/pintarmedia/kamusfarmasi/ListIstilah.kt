package com.pintarmedia.kamusfarmasi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pintarmedia.kamusfarmasi.adapter.FarmasiAdapter
import com.pintarmedia.kamusfarmasi.model.Farmasi
import kotlinx.android.synthetic.main.list_istilah.*
import java.io.IOException

class ListIstilah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_istilah)
        val persone : MutableList<Farmasi> = intent.extras?.get("farmasi") as MutableList<Farmasi>

        Log.i("pcx", persone.toString())
        val farmasiAdapter = FarmasiAdapter({itemClick -> Unit
            //Log.i("click",itemClick.istilah)
            val intent = Intent(this,DetailIstilah::class.java)
            intent.putExtra("farmasi",itemClick)
            startActivity(intent)
        })
        farmasiAdapter.data = persone
        rvList.adapter = farmasiAdapter
        rvList.layoutManager = LinearLayoutManager(this)
    }
}
