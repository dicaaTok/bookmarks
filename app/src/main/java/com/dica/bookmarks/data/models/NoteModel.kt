package com.com.dica.bookmarks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteModel")
data class NoteModel(
    val text: String,

){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}