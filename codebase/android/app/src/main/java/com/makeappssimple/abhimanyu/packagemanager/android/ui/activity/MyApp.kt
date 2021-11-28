package com.makeappssimple.abhimanyu.packagemanager.android.ui.activity

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.packagemanager.android.ui.theme.PackageManagerTheme

@Composable
fun MyApp() {
    val context = LocalContext.current
    val packages = context.packageManager.getInstalledApplications(PackageManager.GET_META_DATA)

    LaunchedEffect(
        key1 = Unit,
        block = {

            for (packageInfo in packages) {
                Log.e("Abhi", "Package name:" + packageInfo.packageName)
            }
        },
    )

    MyAppView(
        packages = packages,
    )
}

@Composable
private fun MyAppView(
    packages: List<ApplicationInfo>,
) {
    LazyColumn {
        itemsIndexed(packages) { _, packageInfo ->
            Text(
                text = packageInfo.packageName,
                modifier = Modifier.padding(
                    all = 8.dp,
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    PackageManagerTheme {
        // MyAppView()
    }
}
