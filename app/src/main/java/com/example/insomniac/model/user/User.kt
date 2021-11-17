package com.example.insomniac.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var gender: String,
    var age: Int,
    var feet: Int,
    var inches: Int,
    var weight: Int,
    var fitness: String,
    var insomnia: Boolean,
    var sleepApnea: Boolean,
    var narcolepsy: Boolean
)


