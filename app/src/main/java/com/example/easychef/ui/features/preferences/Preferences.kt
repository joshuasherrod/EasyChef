package com.example.easychef.ui.features.preferences

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                modifier = Modifier
                    .wrapContentSize(),
                appVer = true
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp, vertical = 12.dp),
                text = "Diet")
            DropDown(
                list = dietOptions,
                isExpanded = dietIsExpanded,
                onExpandedChange = { dietIsExpanded = it },
                selectedText = selectedTextDiet,
                onSelectedChange = { selectedTextDiet = it }
            )
        Spacer(Modifier.height(25.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp, vertical = 12.dp),
                text = "Cuisine")
            DropDown(
                list = cuisineOptions,
                isExpanded = cuisineIsExpanded,
                onExpandedChange = { cuisineIsExpanded = it },
                selectedText = selectedTextCuisine,
                onSelectedChange = { selectedTextCuisine = it }
            )
        Spacer(Modifier.height(25.dp))
        Button(onClick = {
            onGoToHome(id)
        }, text = "Confirm Preferences")
    }
}