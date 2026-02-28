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
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.runtime.SideEffect
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemUiController = rememberSystemUiController()
            val audioPermission = android.Manifest.permission.RECORD_AUDIO
            val storagePermission = android.Manifest.permission.WRITE_EXTERNAL_STORAGE

            var hasAudioPermission by remember { mutableStateOf(false) }
            var hasStoragePermission by remember { mutableStateOf(false) }

            val audioPermissionLauncher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
                    hasAudioPermission = isGranted
                }

            val storagePermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                hasStoragePermission = isGranted
            }
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.White,
                    darkIcons = true // dark icons for light background
                )
            }
            MyApplicationTheme {
                Box(
                    modifier = Modifier.fillMaxSize().background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = Color.Transparent
                    ) { innerPadding ->
                        //wrapping the button in a box to center it on the screen
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            FilledButtonExample(
                                modifier = Modifier.padding(innerPadding),
                                onClick = {
                                    if (!hasAudioPermission) {
                                        audioPermissionLauncher.launch(audioPermission)
                                    } else if (!hasStoragePermission) {
                                        storagePermissionLauncher.launch(storagePermission)
                                    }
                                })

                        }
                    }


                }
            }
        }
    }

    @Composable
    fun FilledButtonExample(onClick: () -> Unit, modifier: Modifier = Modifier) {
        //wrapping the button in a box to center it on the screen
        Button(
            onClick = { onClick() },
            modifier = modifier.size(90.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
        ) {
            Text("Record")
        }
    }
}