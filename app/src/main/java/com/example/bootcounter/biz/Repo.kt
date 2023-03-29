package com.example.bootcounter.biz

import kotlinx.coroutines.flow.Flow

interface Repo {
    fun getBoots(): Flow<List<String>>
    fun saveBoot(timestamp: String)
}