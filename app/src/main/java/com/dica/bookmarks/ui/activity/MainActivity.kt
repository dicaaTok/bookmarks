package com.com.dica.bookmarks.ui.activity

import android.os.Bundle
import android.preference.Preference
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.com.dica.bookmarks.ui.presenter.MainPresenter
import com.com.dica.bookmarks.ui.presenter.MainContract
import com.dica.bookmarks.databinding.ActivityMainBinding


class MainActivity(val preference: Preference) : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainContract.Presenter
    private lateinit var adapter: ArrayAdapter<String>
    private val todos = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        binding.listView.adapter = adapter

        binding.button.setOnClickListener {
            val text = binding.userData.text.toString().trim()
            if (text.isNotEmpty()) {
                presenter.addTodo(text)
            }
        }

        presenter.loadTodos()

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            presenter.deleteTodo(position)
        }
    }

    override fun showTodos(todos: List<String>) {
        this.todos.clear()
        this.todos.addAll(todos)
        adapter.notifyDataSetChanged()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}