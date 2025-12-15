package com.example.easychef.ui.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easychef.ui.components.Button


@Composable
fun HomeScreen(
    id: String,
    onGoToPantry:()-> Unit,
    onGoToPreferences:(String)-> Unit,
    onGoToRecipeSearch:()-> Unit
) {
    val primary = MaterialTheme.colorScheme.primary
    val onPrimary = MaterialTheme.colorScheme.onPrimary

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome back, $id!", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))

        // Pantry button
        Button(
            text = "Pantry",
            onClick = onGoToPantry,
            modifier = Modifier.fillMaxWidth()
        )
        // Preferences button
        Button(
            text = "Preferences",
            onClick = {onGoToPreferences(id) },
            modifier = Modifier.fillMaxWidth()
        )
        // Browse recipes button
        Button(
            text = "Browse recipes",
            onClick = onGoToRecipeSearch,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        id = "DemoUser",
        onGoToPantry = {},
        onGoToPreferences = {},
        onGoToRecipeSearch = {}
    )
}