package com.example.life_cycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.life_cycle.ui.theme.Life_CycleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Life_CycleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DisplayDetails(
                        name = "Ashwin RA2211004020112",
                        subject = "WELCOME BACK",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart()")
    }

    override fun onResume() {
        super.onResume()
        println("onResume()")
    }

    override fun onPause() {
        super.onPause()
        println("onPause()")
    }

    override fun onStop() {
        super.onStop()
        println("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart()")
    }
}

@Composable
fun DisplayDetails(name: String, subject: String, modifier: Modifier = Modifier) {
    Text(
        text = "Name: $name\nSubject: $subject",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    Life_CycleTheme {
        DisplayDetails("Ashwin RA2211004020112", "WELCOME BACK")
    }
}
