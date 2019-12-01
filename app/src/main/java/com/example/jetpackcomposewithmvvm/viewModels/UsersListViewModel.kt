package com.example.jetpackcomposewithmvvm.viewModels

import androidx.lifecycle.MutableLiveData
import com.example.jetpackcomposewithmvvm.models.UserModel

class UsersListViewModel {

    private val usersList: MutableLiveData<ArrayList<UserModel>> by lazy {
        MutableLiveData<ArrayList<UserModel>>()
    }
    private val users: ArrayList<UserModel> = ArrayList()
    fun addUsers() {
        users.add(UserModel("jon", "doe", "android developer"))
        users.add(UserModel("john", "doe", "flutter developer"))
        users.add(UserModel("jonn", "dove", "ios developer"))
        usersList.value = users
    }

    fun getUsers(): MutableLiveData<ArrayList<UserModel>> {
        return usersList
    }

    fun addNewUser() {
        users.add(UserModel("jony", "dove", "ruby developer"))
        usersList.value = users
    }

    fun removeFirstUser() {
        if (!users.isNullOrEmpty()) {
            users.removeAt(0)
            usersList.value = users
        }
    }
}