package com.shs.date.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "start_date")val startDate: String,
    @ColumnInfo(name = "end_date")val endDate: String,
    @ColumnInfo(name = "memo")val memo: String
)