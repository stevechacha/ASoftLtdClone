package com.asoftltd.asoftltd.finance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asoftltd.asoftltd.designsystem.theme.AsTheme
import com.asoftltd.asoftltd.getStatusBarPadding

@Composable
fun FinanceScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(AsTheme.colors.background)
            .padding(
                top = getStatusBarPadding().calculateTopPadding()
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Finance",
            style = AsTheme.typography.headlineLarge,
            color = AsTheme.colors.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "This is the Finance screen.",
            style = AsTheme.typography.headlineLarge,
            color = AsTheme.colors.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = "This is the Finance screen.",
            style = AsTheme.typography.headlineLarge,
            color = AsTheme.colors.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp)
        )


    }


}