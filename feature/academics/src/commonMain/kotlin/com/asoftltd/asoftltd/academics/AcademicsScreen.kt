package com.asoftltd.asoftltd.academics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.asoftltd.asoftltd.getStatusBarPadding
import org.jetbrains.compose.resources.InternalResourceApi

@OptIn(InternalResourceApi::class)
@Composable
fun AcademicsScreen(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize().padding(
            top = getStatusBarPadding().calculateTopPadding()
        ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Academics Screen",
            modifier = Modifier.fillMaxSize()
        )


    }

}