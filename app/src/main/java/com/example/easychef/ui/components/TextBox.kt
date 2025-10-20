package com.example.easychef.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

/**
 *  Outlined Text field that takes user input
 *  @param modifier optional arguments to mutate textbox composable
 *  @param label hint for textbox
 *  @param onValueChange update lambda function for mutable state object
 */

@Composable
fun TextBox(
    modifier: Modifier,
    label: String,
    onValueChange: (String) -> Unit,
    text: String) {

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) }
    )

}