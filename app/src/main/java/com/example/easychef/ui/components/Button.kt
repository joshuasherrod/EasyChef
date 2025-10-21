package com.example.easychef.ui.components

import androidx.compose.material3.Button as M3Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


/**
 * Reusable button composable
 * @param onClick lambda function that executes on click
 * @param modifier optional modifier to mutate composable
 * @param containerColor Background color (default = EasyChef orange)
 * @param contentColor Text color (default = white)
 */
@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Color(0xFFFF7043), //EasyChef orange
    contentColor: Color = Color.White
) {
    M3Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) { Text(text = text) }
}

