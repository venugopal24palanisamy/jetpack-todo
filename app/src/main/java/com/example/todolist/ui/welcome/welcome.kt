package com.example.todolist.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolist.R
import com.example.todolist.ui.navigation.Screen

import com.example.todolist.ui.theme.Blue
import com.example.todolist.ui.theme.LightBlue


@Composable
fun WelcomeView(
    navigationController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        )
        {
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
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.welcome_to),
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            BoxWithConstraints(modifier = Modifier.padding(top = 10.dp)) {
                Text(
                    text = stringResource(R.string.app_name),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            }

            BoxWithConstraints(modifier = Modifier.padding(top = 15.dp)) {
                Text(
                    text = stringResource(R.string.welcome_screen_content),
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(65.dp))


            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navigationController.navigate(Screen.Home.route)
                        //appState.navigateTo("loginScreen")
                    },
                    shape = RoundedCornerShape(35),
                    modifier = Modifier
                        .height(55.dp)
                        .padding(
                            start = 45.dp,
                            end = 45.dp
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightBlue

                    )
                ) {
                    Text(
                        text = stringResource(R.string.try_demo),
                        color = Blue,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Button(
                    onClick = {
                        navigationController.navigate(Screen.Login.route)
                    },
                    shape = RoundedCornerShape(35),
                    modifier = Modifier.height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
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

        }
    }

}


