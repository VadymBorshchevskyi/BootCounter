package com.example.bootcounter.repo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.bootcounter.biz.Repo
import java.time.Instant
import javax.inject.Inject

class BootReceiver @Inject constructor(
    private val repo: Repo
) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action ?: return
        if (action == Intent.ACTION_BOOT_COMPLETED) {
            repo.saveBoot(Instant.now().toEpochMilli().toString())
        }
    }
}