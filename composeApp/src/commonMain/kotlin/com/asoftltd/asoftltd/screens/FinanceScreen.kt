package com.asoftltd.asoftltd.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import asoftltdclone.composeapp.generated.resources.Res
import asoftltdclone.composeapp.generated.resources.academia
import com.asoftltd.asoftltd.utils.getStatusBarPadding
import org.jetbrains.compose.resources.imageResource

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