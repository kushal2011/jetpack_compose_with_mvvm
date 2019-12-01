package com.example.jetpackcomposewithmvvm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.ui.core.setContent
import com.example.jetpackcomposewithmvvm.composableUi.UsersListUi
import com.example.jetpackcomposewithmvvm.states.UsersState
import com.example.jetpackcomposewithmvvm.viewModels.UsersListViewModel

class MainActivity : AppCompatActivity() {
    private val usersState: UsersState = UsersState()
    private val usersListViewModel: UsersListViewModel = UsersListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usersListViewModel.getUsers().observe(this, Observer {
            usersState.users.addAll(it)
        })
        usersListViewModel.addUsers()
        setContent {
            UsersListUi.addList(
                usersState,
                onAddClick = { usersListViewModel.addNewUser() },
                onRemoveClick = { usersListViewModel.removeFirstUser() })
        }
    }

}