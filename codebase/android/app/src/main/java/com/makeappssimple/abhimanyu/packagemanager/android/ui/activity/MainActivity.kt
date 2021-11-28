package com.makeappssimple.abhimanyu.packagemanager.android.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.makeappssimple.abhimanyu.packagemanager.android.ui.theme.PackageManagerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)
        setContent {
            PackageManagerTheme {
                MyApp()
            }
        }
    }
}
