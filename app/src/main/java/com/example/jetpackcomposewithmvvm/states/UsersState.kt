package com.example.jetpackcomposewithmvvm.states

import androidx.compose.Model
import com.example.jetpackcomposewithmvvm.models.UserModel

@Model
class UsersState(var users:ArrayList<UserModel> = ArrayList())