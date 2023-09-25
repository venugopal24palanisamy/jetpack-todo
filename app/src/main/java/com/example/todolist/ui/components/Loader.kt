package com.example.todolist.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.todolist.ui.theme.Blue

@Composable
fun LoadingDialog(
    isLoading: Boolean,
    message: String,
    onDismiss: () -> Unit
) {








}

@Composable
fun CircularLoader(){
    val strokeWidth = 5.dp
    CircularProgressIndicator(
        modifier = Modifier.drawBehind {
            drawCircle(
                Blue,
                radius = size.width / 2 - strokeWidth.toPx() / 2,
                style = Stroke(strokeWidth.toPx())
            )
        },
        color = Color.LightGray,
        strokeWidth = strokeWidth
    )
}