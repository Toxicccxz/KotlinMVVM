package com.xavier.kotlinmvvm.ui.component.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.xavier.kotlinmvvm.SPLASH_DELAY
import com.xavier.kotlinmvvm.databinding.SplashLayoutBinding
import com.xavier.kotlinmvvm.ui.base.BaseActivity
import com.xavier.kotlinmvvm.ui.component.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity(){

    private lateinit var binding: SplashLayoutBinding

    override fun initViewBinding() {
        binding = SplashLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainScreen()
    }

    override fun observeViewModel() {
    }

    private fun navigateToMainScreen() {
        Handler().postDelayed({
            val nextScreenIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextScreenIntent)
            finish()
        }, SPLASH_DELAY.toLong())
    }
}