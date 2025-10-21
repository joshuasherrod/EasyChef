package com.example.easychef.ui.features.pantry

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easychef.ui.components.Button

@Composable //note, Unit = {} is a default empty lambda
fun PantryScreen(onBackToHome: () -> Unit ={}) {
    var newItem by remember { mutableStateOf("") }
    val pantryItems = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Text("Your Pantry", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

       //Easy Chef Orange Implemented, it's 0xFFFF7043
        val addColor = Color(0xFFFF7043)

        Button(
            text = "Add",
            onClick = {
                if (newItem.isNotBlank()) {
                    pantryItems.add(newItem.trim())
                    newItem = ""
                }
            },
            containerColor = addColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        pantryItems.forEach { item ->
            Text("- $item", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            text = "Back to Home",
            onClick = onBackToHome,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    PantryScreen()
}