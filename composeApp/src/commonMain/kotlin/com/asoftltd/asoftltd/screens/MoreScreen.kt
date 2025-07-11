package com.asoftltd.asoftltd.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.asoftltd.asoftltd.utils.getStatusBarPadding

@Composable
fun MoreScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(
                top = getStatusBarPadding().calculateTopPadding()

            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "More Screen",
            modifier = Modifier.fillMaxSize()
        )
    }

}