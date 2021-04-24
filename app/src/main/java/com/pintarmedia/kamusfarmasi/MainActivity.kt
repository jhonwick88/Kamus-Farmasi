package com.pintarmedia.kamusfarmasi

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pintarmedia.kamusfarmasi.model.Farmasi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private val JSON_FARMASI = "farmasi.json"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonFileString = getJsonDataFromAsset(applicationContext, JSON_FARMASI)
        val gson = Gson()
        val listPersonType = object : TypeToken<List<Farmasi>>() {}.type
        val persons: List<Farmasi> = gson.fromJson(jsonFileString, listPersonType)
        val sds: MutableList<Farmasi> = persons.map { it }.toMutableList()
        val istilah: MutableList<String> = persons.map { it.istilah }.toMutableList()
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line, istilah)
        edtSearch.setAdapter(adapter)
        edtSearch.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selected1 = adapterView.getItemAtPosition(position).toString()
            val selected2 : List<Farmasi> = persons.filter { farmasi: Farmasi -> farmasi.istilah == selected1 }
            startActivity(Intent(this,DetailIstilah::class.java).putExtra("farmasi",selected2[0]))
        }
        btnList.setOnClickListener {
            val intent = Intent(this, ListIstilah::class.java)
            intent.putExtra("farmasi",sds as Serializable)
            startActivity(intent)
        }

    }

    fun getJsonDataFromAsset(context: Context, s: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(s).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}
