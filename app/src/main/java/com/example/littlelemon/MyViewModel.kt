package com.example.littlelemon

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {


    private val database = AppDatabase.getInstance(application)
    private val dao = database.menuItemDao()

    fun getAllDatabaseMenuItems(): LiveData<List<MenuItemRoom>> {
        return dao.getAll()
    }

    fun fetchMenuDataIfNeeded() {
        viewModelScope.launch(Dispatchers.IO) {
            if (dao.count() == 0) {
                val menuItems = fetchMenu(
                    "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
                )
                dao.insertAll(menuItems)
            }
        }
    }
}