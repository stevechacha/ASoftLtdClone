package com.asoftltd.asoftltd.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import asoftltdclone.composeapp.generated.resources.Res
import asoftltdclone.composeapp.generated.resources.compose_multiplatform
import coil3.compose.AsyncImage
import coil3.compose.setSingletonImageLoaderFactory
import com.asoftltd.asoftltd.utils.getAsyncImageLoader
import com.asoftltd.asoftltd.utils.getStatusBarPadding
import com.seiko.imageloader.ImageLoader
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.getResourceUri

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