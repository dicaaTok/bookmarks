package com.dica.bookmarks

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.dica.bookmarks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val userData: EditText = findViewById(R.id.user_data)
        val button: Button = findViewById(R.id.button)

        val todos: MutableList<String> = mutableListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        listView.adapter = adapter

        listView.setOnItemClickListener{ adapterView, view , i, l ->
            val text =listView.getItemAtPosition(i).toString()
            adapter.remove(text)

            Toast.makeText(this,"Выполнено: $text", Toast.LENGTH_SHORT ).show()

        }

        button.setOnClickListener {
            val text = userData.text.toString().trim()
            if (text != "")
                adapter.insert(text,0)

        }
    }

}