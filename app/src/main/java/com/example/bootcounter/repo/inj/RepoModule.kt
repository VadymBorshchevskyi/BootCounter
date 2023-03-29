package com.example.bootcounter.repo.inj

import com.example.bootcounter.biz.Repo
import com.example.bootcounter.repo.db.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    fun bindRepo(mainRepo: RepoImpl): Repo
}