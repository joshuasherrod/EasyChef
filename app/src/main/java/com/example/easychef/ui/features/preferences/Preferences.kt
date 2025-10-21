package com.example.easychef.ui.features.preferences

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.easychef.ui.components.AppLogo
import com.example.easychef.ui.components.Button
import com.example.easychef.ui.components.DropDown
@Composable
fun Preferences(id: String, onGoToHome: (String) -> Unit) {
    val dietOptions: List<String> = listOf("Test1", "Test2", "Test3")
    val cuisineOptions: List<String> = listOf("Test1", "Test2", "Test3")

    var dietIsExpanded by remember { mutableStateOf(false) }
    var cuisineIsExpanded by remember { mutableStateOf(false) }
    var selectedTextDiet by remember { mutableStateOf(dietOptions[0]) }
    var selectedTextCuisine by remember { mutableStateOf(cuisineOptions[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogo(
            modifier = Modifier.wrapContentSize(),
            appVer = true
        )
        Spacer(Modifier.height(32.dp))
        //Diet Section
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = "Diet")
            DropDown(
                list = dietOptions,
                isExpanded = dietIsExpanded,
                onExpandedChange = { dietIsExpanded = it },
                selectedText = selectedTextDiet,
                onSelectedChange = { selectedTextDiet = it }
            )
        Spacer(Modifier.height(24.dp))

        //Cuisine Section
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = "Cuisine")
            DropDown(
                list = cuisineOptions,
                isExpanded = cuisineIsExpanded,
                onExpandedChange = { cuisineIsExpanded = it },
                selectedText = selectedTextCuisine,
                onSelectedChange = { selectedTextCuisine = it }
            )
        Spacer(Modifier.height(40.dp))

        //So when confirmed it goes back to home
        Button(
            text = "Confirm Preferences",
            onClick = { onGoToHome(id) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
        )
    }
}