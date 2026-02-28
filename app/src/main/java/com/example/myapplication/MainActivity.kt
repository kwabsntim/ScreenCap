package com.example.myapplication

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
import androidx.compose.material3.Button
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FilledButtonExample(
                        modifier=Modifier.padding(innerPadding),
                        onClick ={

                        })

                        }

                }
            }
        }
    }



@Composable
fun FilledButtonExample(onClick: () -> Unit,modifier: Modifier=Modifier) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        shape= CircleShape,
        colors=ButtonDefaults.buttonColors(containerColor = Color.Red,contentColor=Color.White),
    ) {
        Text("Start Recording")
    }
}
