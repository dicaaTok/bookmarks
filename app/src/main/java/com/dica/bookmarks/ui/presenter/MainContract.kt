package com.com.dica.bookmarks.ui.presenter

interface MainContract {
    interface View {
        fun showTodos(todos: List<String>)
        fun showToast(message: String)
    }

    interface Presenter {
        fun addTodo(text: String)
        fun loadTodos()
        fun deleteTodo(position: Int)
    }
}