package com.example.jetpackcomposewithmvvm.composableUi

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.Row
import androidx.ui.layout.WidthSpacer
import androidx.ui.material.*
import com.example.jetpackcomposewithmvvm.states.UsersState

object UsersListUi {

    @Composable
    fun addList(state: UsersState) {
        MaterialTheme {
            FlexColumn {
                inflexible {
                    // Item height will be equal content height
                    TopAppBar( // App Bar with title
                        title = { Text("Users") }
                    )
                    VerticalScroller {
                        Column {
                            state.users.forEach {
                                Column {
                                    Row {
                                        Text(text = it.userName)
                                        WidthSpacer(width = 2.dp)
                                        Text(text = it.userSurName)
                                    }
                                    Text(text = it.userJob)

                                }
                                Divider(color = Color.Black, height = 1.dp)

                            }
                        }
                    }
                }

            }
        }

    }


}