package com.makeappssimple.abhimanyu.packagemanager.android.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.makeappssimple.abhimanyu.packagemanager.android.ui.theme.PackageManagerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageManagerTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Text(
        text = "Hello Android!",
    )
}

@Preview(
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    PackageManagerTheme {
        Greeting()
    }
}