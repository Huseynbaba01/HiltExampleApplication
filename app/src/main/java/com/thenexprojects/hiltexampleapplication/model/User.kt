package com.thenexprojects.hiltexampleapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id:Long? = null,
    var username: String,
    var name: String,
    var age: Int
)