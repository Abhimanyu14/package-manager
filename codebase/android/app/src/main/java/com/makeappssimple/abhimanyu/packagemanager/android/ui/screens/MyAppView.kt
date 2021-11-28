package com.makeappssimple.abhimanyu.packagemanager.android.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.packagemanager.android.ui.data.ItemData

@Composable
fun MyAppView(
    packages: List<ItemData>,
) {
    val (searchText, setSearchText) = remember {
        mutableStateOf("")
    }
    val filteredPackages = if (searchText.isBlank()) {
        packages
    } else {
        packages.filter {
            it.packageName.contains(searchText)
        }
    }

    if (packages.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator(
                color = Color.Black,
            )
        }

    } else {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            TextField(
                value = searchText,
                onValueChange = setSearchText,
                shape = RoundedCornerShape(
                    percent = 50,
                ),
                singleLine = true,
                colors = TextFieldDefaults
                    .textFieldColors(
                        backgroundColor = Color(
                            color = 0xFFEFEFEF,
                        ),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = null,
                    )
                },
                trailingIcon = if (searchText.isNotBlank()) {
                    {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(
                                    shape = CircleShape,
                                )
                                .clickable {
                                    setSearchText("")
                                },
                        )
                    }
                } else {
                    null
                },
                placeholder = {
                    Text(
                        text = "Search using package name",
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 8.dp,
                        horizontal = 16.dp,
                    ),
            )
            LazyColumn {
                itemsIndexed(filteredPackages) { _, itemData ->
                    ItemView(
                        data = itemData,
                    )
                }
            }
        }
    }
}
