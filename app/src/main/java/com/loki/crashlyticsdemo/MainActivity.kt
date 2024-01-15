package com.loki.crashlyticsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.loki.crashlyticsdemo.ui.theme.CrashlyticsDemoTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrashlyticsDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {
                                simulateError()
                            }
                        ) {
                            Text(text = "Throw Error")
                        }
                    }
                }
            }
        }
    }
}

private fun simulateError() {
    try {
        // Some code that may throw an exception
        throw RuntimeException("Simulated error for demonstration purposes.")
    } catch (e: Exception) {
        // Log the error using Timber
        Timber.e(e, "An error occurred in the MainActivity")
    }
}