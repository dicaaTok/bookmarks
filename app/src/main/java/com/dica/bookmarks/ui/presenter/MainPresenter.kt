package com.com.dica.bookmarks.ui.presenter

import com.App
import com.com.dica.bookmarks.data.models.NoteModel

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    private val todos = mutableListOf<String>()

    override fun addTodo(text: String) {
        todos.add(0, text)
        view.showTodos(todos)
        App.appDataBase?.noteDao()?.insertNote(NoteModel(text))
    }

    override fun loadTodos() {
        val notes = App.appDataBase?.noteDao()?.getAll()?.value.orEmpty()
        val items = notes.map { it.text }
        todos.clear()
        todos.addAll(items)
        view.showTodos(todos)
    }

    override fun deleteTodo(position: Int) {
        val removed = todos.removeAt(position)
        view.showTodos(todos)
        view.showToast("Удалено: $removed")
    }
}