package com.example.bootcounter.repo.db.dao

import androidx.room.*
import com.example.bootcounter.repo.db.model.DbBoot
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BootDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBoot(boot: DbBoot)

    @Transaction
    @Query(value = "SELECT * FROM boots")
    abstract fun getBoots(): Flow<List<DbBoot>>
}