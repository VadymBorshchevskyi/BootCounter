package com.example.bootcounter.repo.db

import com.example.bootcounter.biz.Repo
import com.example.bootcounter.repo.db.model.DbBoot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoImpl @Inject constructor(
    private val db: Db
) : Repo {

    override fun getBoots(): Flow<List<String>> =
        db.bootDao.getBoots().map { dbBoots -> dbBoots.map { dbBoot -> dbBoot.timestamp } }

    override fun saveBoot(timestamp: String) {
        db.bootDao.insertBoot(DbBoot(timestamp = timestamp))
    }

}