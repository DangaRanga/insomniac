package com.example.insomniac.model.stats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "awake")
class StatsAwake (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var StartCurrentDate: String,
    var CurrentStartTime: String
)


