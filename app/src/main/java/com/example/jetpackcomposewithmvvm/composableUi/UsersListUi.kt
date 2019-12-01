package com.example.jetpackcomposewithmvvm.composableUi

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import com.example.jetpackcomposewithmvvm.states.UsersState

object UsersListUi {

    @Composable
    fun addList(state: UsersState, onAddClick: () -> Unit, onRemoveClick: () -> Unit) {
        MaterialTheme {
            FlexColumn {
                inflexible {
                    // Item height will be equal content height
                    TopAppBar( // App Bar with title
                        title = { Text("Users") }
                    )
                    FlexRow() {
                        expanded(flex = 1f) {
                            Button(
                                text = "add",
                                onClick = { onAddClick.invoke() },
                                style = OutlinedButtonStyle()
                            )

                        }
                        expanded(flex = 1f) {
                            Button(
                                text = "sub",
                                onClick = { onRemoveClick.invoke() },
                                style = OutlinedButtonStyle()
                            )
                        }
                    }
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