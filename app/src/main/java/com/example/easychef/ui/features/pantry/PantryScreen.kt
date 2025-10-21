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

@Composable
fun PantryScreen() {
    var newItem by remember { mutableStateOf("") }
    val pantryItems = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Your Pantry",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        //this is just a placeholder green color, change to probably easychef orange
        val buttonColor = Color(0xFF4CAF50) //green

        Button(
            text = "Add Example Item",
            onClick = {
                pantryItems.add("Ingredient ${pantryItems.size + 1}")
            },
            // If the button in ui components doesn’t take a color param yet, we’ll handle that next for that color
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        pantryItems.forEach { item ->
            Text("- $item", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantryScreenPreview() {
    PantryScreen()
}