package com.makeappssimple.abhimanyu.packagemanager.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.packagemanager.android.ui.data.ItemData
import com.makeappssimple.abhimanyu.packagemanager.android.ui.theme.PackageManagerTheme

@Composable
fun ItemView(
    data: ItemData,
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            data.icon?.let {
                Image(
                    bitmap = data.icon,
                    contentDescription = null,
                    modifier = Modifier.padding(
                        all = 4.dp,
                    ),
                )
            }
            Column(
                modifier = Modifier
                    .weight(
                        weight = 1f,
                    ),
            ) {
                Text(
                    text = data.label,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 0.dp,
                    ),
                )
                Text(
                    text = data.packageName,
                    modifier = Modifier.padding(
                        top = 0.dp,
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp,
                    ),
                )
            }
        }
        Divider(
            color = Color.LightGray,
        )
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
