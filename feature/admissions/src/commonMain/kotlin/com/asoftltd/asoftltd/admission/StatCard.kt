package com.asoftltd.asoftltd.admission

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoftltd.asoftltd.StatData
import com.asoftltd.asoftltd.designsystem.Res
import com.asoftltd.asoftltd.designsystem.graphvector
import org.jetbrains.compose.resources.painterResource


@Composable
fun StatCard(data: StatData) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(128.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1D25)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    painter = painterResource(data.iconRes),
                    contentDescription = "Growth Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(data.growthColor.copy(alpha = 0.15f), CircleShape)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text(
                        text = data.growth.toString(),
                        fontSize = 12.sp,
                        color = data.growthColor,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }

            }

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = data.value,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = data.label,
                        fontSize = 12.sp,
                        color = Color.LightGray
                    )
                }

                Spacer(Modifier.weight(1f))

                Image(
                    painter = painterResource(Res.drawable.graphvector), // Use placeholder
                    contentDescription = "Stat Icon",
                    modifier = Modifier
                        .height(48.dp)
                        .width(120.dp),
                    colorFilter = ColorFilter.tint(data.growthColor)
                )

            }
        }
    }
}