package com.example.todolist.ui.components
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.ui.theme.Blue
import com.example.todolist.ui.theme.TodoListTheme

@Composable
fun CircularLoader() {
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

@Preview(showSystemUi = true)
@Composable
fun LoaderPreview() {
    TodoListTheme {
        CircularLoader()
    }
}