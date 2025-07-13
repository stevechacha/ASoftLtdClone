package com.asoftltd.asoftltd.finance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.asoftltd.asoftltd.getStatusBarPadding

@Composable
fun FinanceScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(
                top = getStatusBarPadding().calculateTopPadding()
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Finance Screen",
            modifier = Modifier.fillMaxSize()
        )


    }


}