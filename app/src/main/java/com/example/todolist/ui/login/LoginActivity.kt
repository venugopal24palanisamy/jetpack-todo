package com.example.todolist.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.todolist.R
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
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                val (loginTitleLabel, loginUserNameField) = createRefs()
                Text(text = stringResource(id = R.string.login),
                    modifier = Modifier.constrainAs(loginTitleLabel) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        //bottom.linkTo(parent.bottom)
                    })

                OutlinedTextField(value = loginUserName,
                    onValueChange = {
                        loginUserName = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(loginUserNameField) {
                            top.linkTo(loginTitleLabel.bottom, margin = 15.dp)
                        },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.user_name),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    })
            }
        }
    }


    fun setUserLoginConstraints(): ConstraintSet {

        return ConstraintSet {


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