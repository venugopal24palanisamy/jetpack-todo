package com.example.todolist.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.ui.theme.Blue

@Composable
fun DrawerHeader() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Blue),
        contentAlignment = Alignment.CenterStart
    ) {
        Card(
            modifier = Modifier
                .padding(15.dp)
                .height(50.dp)
                .width(50.dp),
            colors = CardDefaults.cardColors(containerColor = Blue),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            BoxWithConstraints {

                Image(
                    painter = painterResource(id = R.drawable.baseline_done),
                    contentDescription = stringResource(
                        id = R.string.add_list
                    ), modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(10.dp)
                )

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DrawerHeaderPreview() {
    DrawerHeader()
}