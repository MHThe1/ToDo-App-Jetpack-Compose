package com.kotlintut.todoapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlintut.todoapp.data.Task
import com.kotlintut.todoapp.ui.theme.ToDoAppTheme

@Composable
fun TaskItem(
    task: Task,
    onToggleCompletion: (Task) -> Unit,
    onDelete: (Task) -> Unit

) {

    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { isVisible = true }

    AnimatedVisibility(visible = isVisible) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable {},
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TaskTitleRow(
                        task = task,
                        onToggleCompletion = onToggleCompletion
                    )
                }

                IconButton(
                    onClick = {onDelete(task)},
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer,
                        contentColor = MaterialTheme.colorScheme.onErrorContainer
                    )
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete todo")
                }
            }
        }
    }
}


@Composable
fun TaskTitleRow(
    task: Task,
    onToggleCompletion: (Task) -> Unit
) {
    var customColor = Color(0xFF1E88E5)
    var textCustomDecoration = TextDecoration.None

    if(task.isCompleted){
        customColor = Color(0xFF43A047)
        textCustomDecoration = TextDecoration.LineThrough
    }

    IconButton(onClick = {onToggleCompletion(task)}) {
        Icon(Icons.Default.CheckCircle, contentDescription = "mark done",
            tint = customColor)
    }
    Text(text = task.title,
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        ),
        textDecoration = textCustomDecoration)
}


@Preview(showBackground = true)
@Composable
fun PreviewTaskItem() {
    ToDoAppTheme {
//        TaskItem()
    }
}