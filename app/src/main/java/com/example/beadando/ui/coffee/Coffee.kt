package com.example.beadando.ui.coffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.beadando.R

class Coffee : AppCompatActivity() {

    var array = arrayOf("Espresso", "Lungo", "Machiato", "Americano", "Cappuchino", "Latte",
        "Cold Brew", "French Press", "Cortado", "Flat White", "Spanis", "Risretto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee)

        val adapter = ArrayAdapter(this,
            R.layout.listview_item, array)

        val listView: ListView = findViewById(R.id.coffees)
        listView.setAdapter(adapter)

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                val itemValue = listView.getItemAtPosition(position) as String

                Toast.makeText(applicationContext,
                    "$itemValue", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
