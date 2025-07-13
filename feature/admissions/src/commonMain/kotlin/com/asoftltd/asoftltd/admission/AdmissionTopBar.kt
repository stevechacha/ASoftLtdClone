package com.asoftltd.asoftltd.admission

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoftltd.asoftltd.designsystem.Res
import com.asoftltd.asoftltd.designsystem.*
import org.jetbrains.compose.resources.painterResource


@Composable
fun AdmissionTopBars(
    onSearchClick: () -> Unit,
    onProfileClick: () -> Unit,
    hasNotification: Boolean = true
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(Res.drawable.academia),
            contentDescription = "Academia Logo",
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Admission",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onSearchClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        ProfileWithBadge()

    }
}

@Composable
fun ProfileWithBadge() {
    Box(
        modifier = Modifier
            .size(64.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.user_story),
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 8.dp)
                .size(28.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.badge),
                contentDescription = "Star badge",
                colorFilter = ColorFilter.tint(Color.Yellow),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
    }
}

