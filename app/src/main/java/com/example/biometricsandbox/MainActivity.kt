package com.example.biometricsandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var biometricPrompt: BiometricPrompt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        biometricPrompt = createBiometricPrompt()
    }

    override fun onResume() {
        super.onResume()
        biometricPrompt.authenticate(getBiometricPromptInfo())
    }

    private fun createBiometricPrompt() = BiometricPrompt(
        this,
        ContextCompat.getMainExecutor(this),
        object : BiometricPrompt.AuthenticationCallback() { })

    private fun getBiometricPromptInfo() = PromptInfo.Builder()
        .setTitle("Title")
        .setDescription("Description")
        .setNegativeButtonText("Cancel")
        .build()
}
