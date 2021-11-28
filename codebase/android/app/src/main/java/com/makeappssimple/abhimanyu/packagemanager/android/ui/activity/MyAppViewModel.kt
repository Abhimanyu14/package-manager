package com.makeappssimple.abhimanyu.packagemanager.android.ui.activity

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makeappssimple.abhimanyu.packagemanager.android.ui.data.ItemData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyAppViewModel : ViewModel() {
    private var _packages: MutableLiveData<List<ItemData>> = MutableLiveData(emptyList())
    val packages: LiveData<List<ItemData>>
        get() = _packages

    fun getUserInstalledPackages(
        context: Context,
    ) {
        viewModelScope.launch(
            Dispatchers.IO
        ) {
            _packages.postValue(
                context
                    .packageManager
                    .getInstalledApplications(PackageManager.GET_META_DATA)
                    .filter {
                        // Filter out system packages
                        it.flags and ApplicationInfo.FLAG_SYSTEM == 0
                    }.sortedBy {
                        it.packageName
                    }.map { applicationInfo ->
                        ItemData(
                            icon = applicationInfo
                                .loadIcon(context.packageManager)
                                ?.toBitmap(
                                    height = 120,
                                    width = 120,
                                )
                                ?.asImageBitmap(),
                            label = applicationInfo.loadLabel(context.packageManager).toString(),
                            packageName = applicationInfo.packageName,
                        )
                    }
            )
        }
    }
}
