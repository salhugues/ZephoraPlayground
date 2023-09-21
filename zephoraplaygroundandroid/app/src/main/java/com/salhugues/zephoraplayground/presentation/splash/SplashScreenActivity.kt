package com.salhugues.zephoraplayground.presentation.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.salhugues.zephoraplayground.databinding.ActivitySplashscreenBinding
import com.salhugues.zephoraplayground.domain.usecase.SyncDataUseCase
import com.salhugues.zephoraplayground.presentation.home.HomeActivity
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    private val syncDataUseCase by inject<SyncDataUseCase>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            val syncDataResult = lifecycleScope.async {
                syncDataUseCase()
            }.await()

            if (syncDataResult.data == true) {
                startActivity(
                    Intent(this@SplashScreenActivity, HomeActivity::class.java)
                )
            }
        }
    }
}