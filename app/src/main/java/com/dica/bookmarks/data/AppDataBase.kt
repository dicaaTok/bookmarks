package com.com.dica.bookmarks.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.com.dica.bookmarks.data.db.NoteDao
import com.com.dica.bookmarks.data.models.NoteModel

@Database(entities = [NoteModel::class], version = 3)
abstract class AppDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

}