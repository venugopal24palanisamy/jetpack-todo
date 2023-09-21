package com.example.todolist.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.todolist.R
import com.example.todolist.ui.theme.Blue
import com.example.todolist.ui.theme.TodoListTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {
                Login()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login() {
        var loginUserName by remember { mutableStateOf("") }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(), constraintSet = setUserLoginConstraints()
            ) {
                Text(
                    text = stringResource(R.string.login),
                    modifier = Modifier
                        .fillMaxWidth()
                        .layoutId("loginTitle"),
                    style = MaterialTheme.typography.titleLarge,
                    color = Blue
                )
                Box(
                    modifier = Modifier
                        .layoutId("loginSubTitle")
                        .padding(top = 15.dp)
                ) {
                    Text(
                        text = stringResource(R.string.welcome_back),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray,
                    )
                }
                Box(
                    Modifier
                        .padding(top = 15.dp)
                        .layoutId("loginUserName")
                ) {
                    OutlinedTextField(
                        value = loginUserName,
                        onValueChange = {
                            loginUserName = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(20),
                        textStyle = MaterialTheme.typography.bodyMedium,
                        placeholder = {
                            Text(
                                text = stringResource(R.string.user_name),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                    )
                }

            }
        }
    }

    @Composable
    fun setUserLoginConstraints(): ConstraintSet {
        return ConstraintSet {
            val loginTitleConstraint = createRefFor("loginTitle")
            val loginSubTitleConstraint = createRefFor("loginSubTitle")
            val loginUserNameConstraint = createRefFor("loginUserName")
            val loginPasswordConstraint = createRefFor("loginPassword")
            constrain(loginTitleConstraint) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }

            constrain(loginSubTitleConstraint) {
                top.linkTo(loginTitleConstraint.bottom)
                start.linkTo(parent.start)
            }

            constrain(loginUserNameConstraint) {
                top.linkTo(loginSubTitleConstraint.bottom)
            }

            constrain(loginPasswordConstraint) {
                top.linkTo(loginUserNameConstraint.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun LoginScreenPreview() {
        TodoListTheme {
            Login()
        }
    }

}