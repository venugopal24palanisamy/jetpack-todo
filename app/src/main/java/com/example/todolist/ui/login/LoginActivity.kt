package com.example.todolist.ui.login


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign


import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

import com.example.todolist.R
import com.example.todolist.modal.LoginRequestData
import com.example.todolist.ui.components.CircularLoader
import com.example.todolist.ui.navigation.Screen

import com.example.todolist.ui.theme.Blue
import com.example.todolist.ui.theme.LightBlue
import com.example.todolist.utilz.MyFunctions
import com.example.todolist.utilz.Status


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val loginData by viewModel.loginData.observeAsState()
    when (loginData?.status) {
        Status.LOADING -> viewModel.isLoading = true
        Status.SUCCESS -> {
            Toast.makeText(
                context,
                loginData?.data?.firstName ?: context.getString(R.string.n_a),
                Toast.LENGTH_SHORT
            ).show()
            viewModel.isLoading = false
            MyFunctions.loggedInPreferences(
                context,
                loginData?.data
            )
            navController.navigate(Screen.Home.route)
        }

        Status.ERROR -> {
            Toast.makeText(
                context,
                loginData!!.message,
                Toast.LENGTH_SHORT
            ).show()
            viewModel.isLoading = false
        }

        else -> {}
    }
    fun validate(): Boolean {
        if (viewModel.loginUserName.isEmpty()) {
            viewModel.isUserNameError = true
            viewModel.loginUserNameError = context.getString(R.string.enter_user_name)
            return false
        } else {
            viewModel.isUserNameError = false
            viewModel.loginUserNameError = ""
        }
        if (viewModel.loginUserPassword.isEmpty()) {
            viewModel.isPasswordError = true
            viewModel.loginUserPasswordError = context.getString(R.string.enter_password)
            return false
        } else {
            viewModel.isPasswordError = false
            viewModel.loginUserPasswordError = ""
        }
        return true
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BoxWithConstraints(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .height(50.dp)
                            .width(50.dp)
                            .fillMaxWidth()
                            .background(
                                color = Blue,
                                shape = RoundedCornerShape(15)
                            ),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_done),
                            contentDescription = stringResource(
                                id = R.string.app_name
                            ), modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(15.dp)
                        )
                    }
                }
                BoxWithConstraints(modifier = Modifier.padding(top = 10.dp)) {
                    Text(
                        text = stringResource(R.string.app_name),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )
                }
                Card(
                    modifier = Modifier.padding(15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(
                        hoveredElevation = 10.dp,
                        defaultElevation = 8.dp
                    )
                ) {
                    ConstraintLayout(
                        modifier = Modifier
                            .padding(15.dp)
                            .fillMaxWidth(),

                        constraintSet = setUserLoginConstraints()
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
                                value = viewModel.loginUserName,
                                onValueChange = {
                                    viewModel.loginUserName = it
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
                                ), isError = viewModel.isUserNameError, supportingText = {
                                    if (viewModel.isUserNameError) Text(
                                        text = viewModel.loginUserNameError,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            )


                        }
                        Box(
                            Modifier
                                .padding(top = 15.dp)
                                .layoutId("loginPassword")
                        ) {
                            OutlinedTextField(
                                visualTransformation = if (viewModel.isPasswordToggled) VisualTransformation.None else PasswordVisualTransformation(),
                                value = viewModel.loginUserPassword,
                                onValueChange = {
                                    viewModel.loginUserPassword = it
                                },
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(20),
                                textStyle = MaterialTheme.typography.bodyMedium,
                                placeholder = {
                                    Text(
                                        text = stringResource(R.string.password),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Done
                                ), isError = viewModel.isPasswordError, supportingText = {
                                    if (viewModel.isPasswordError) Text(
                                        text = viewModel.loginUserPasswordError,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            )
                        }


                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .layoutId("loginButton")
                                .padding(top = 15.dp)
                        ) {
                            Button(
                                onClick = {
                                    if (validate()) {
                                        viewModel.loginCall(
                                            context,
                                            LoginRequestData(
                                                viewModel.loginUserName,
                                                viewModel.loginUserPassword
                                            )
                                        )
                                    }
                                },
                                shape = RoundedCornerShape(35),
                                modifier = Modifier
                                    .height(55.dp)
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = LightBlue
                                )
                            ) {
                                Text(
                                    text = stringResource(R.string.login),
                                    color = Blue,
                                    style = MaterialTheme.typography.labelLarge,
                                    modifier = Modifier.padding(5.dp)
                                )
                            }
                        }
                        if (viewModel.isLoading)
                            Box(modifier = Modifier.layoutId("loginLoader")) {
                                CircularLoader()
                            }
                    }
                }
            }
        }
    }
}

fun setObserver() {

}

@Composable
fun setUserLoginConstraints(): ConstraintSet {
    return ConstraintSet {
        val loginTitleConstraint = createRefFor("loginTitle")
        val loginSubTitleConstraint = createRefFor("loginSubTitle")
        val loginUserNameConstraint = createRefFor("loginUserName")
        val loginPasswordConstraint = createRefFor("loginPassword")
        val loginButtonConstraint = createRefFor("loginButton")
        val loginLoaderConstraint = createRefFor("loginLoader")

        constrain(loginLoaderConstraint) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

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

        constrain(loginButtonConstraint) {
            top.linkTo(loginPasswordConstraint.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }

}


