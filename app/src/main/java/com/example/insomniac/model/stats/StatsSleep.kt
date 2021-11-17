package com.example.insomniac.model.stats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep")
class StatsSleep (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var StopCurrentDate: Int,
    var CurrentStopTime: Int,
    var Timer_Value: Int
)


