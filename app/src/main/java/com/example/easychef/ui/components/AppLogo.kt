package com.example.easychef.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.easychef.R

/**
 *  Reusable logo composable
 *  @param modifier Optional arguments to mutate logo composable
 *  @param appVer true = use the app logo version, false = use regular version
 */

@Composable
fun AppLogo(modifier: Modifier, appVer: Boolean) {
    val logo: Painter = if (!appVer) {
        painterResource(id = R.drawable.logoandname)
    } else {
        painterResource(id = R.drawable.appver2)
    }

    Image(
        painter = logo,
        contentDescription = "EasyChef App Logo",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )

}