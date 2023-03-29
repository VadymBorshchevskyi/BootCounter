package com.example.bootcounter.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bootcounter.biz.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BootViewModel @Inject constructor(
    repo: Repo
) : ViewModel() {
    val boots = repo.getBoots()
}