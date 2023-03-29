package com.example.bootcounter.repo.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "boots"
)
data class DbBoot(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val timestamp: String,
)
