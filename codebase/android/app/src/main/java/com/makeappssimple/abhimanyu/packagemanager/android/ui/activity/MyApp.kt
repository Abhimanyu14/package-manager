package com.makeappssimple.abhimanyu.packagemanager.android.ui.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.makeappssimple.abhimanyu.packagemanager.android.ui.screens.MyAppView

@Composable
fun MyApp(
    viewModel: MyAppViewModel = MyAppViewModel(),
) {
    val context = LocalContext.current
    val packages by viewModel.packages.observeAsState()

    LaunchedEffect(
        key1 = Unit,
    ) {
        viewModel
            .getUserInstalledPackages(
                context = context,
            )
    }

    MyAppView(
        packages = packages ?: emptyList(),
    )
}
