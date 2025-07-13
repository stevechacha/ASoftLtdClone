package com.asoftltd.asoftltd.admission

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.asoftltd.asoftltd.designsystem.theme.AsTheme
import com.asoftltd.asoftltd.domain.model.Applicant
import com.asoftltd.asoftltd.domain.model.PaymentStatus
import com.asoftltd.asoftltd.getCountryCodeFromName
import com.asoftltd.asoftltd.getFlagEmojiFor
import com.asoftltd.asoftltd.randomColor
import io.ktor.util.toLowerCasePreservingASCIIRules


@Composable
fun ApplicantItem(applicant: Applicant) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (applicant.profileImage != null) {
            AsyncImage(
                model = applicant.profileImage,
                contentDescription = "Applicant Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .wrapContentSize(Alignment.Center)
            )
        } else {
            Text(
                text = applicant.name.take(1).uppercase(),
                color = AsTheme.colors.onBackground,
                modifier = Modifier
                    .size(40.dp)
                    .background(randomColor(), CircleShape)
                    .wrapContentSize(Alignment.Center)
            )
        }

        Spacer(Modifier.width(10.dp))

        Column(Modifier.weight(1f)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = applicant.name,
                    color = AsTheme.colors.onBackground,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    applicant.paymentStatus.displayName,
                    color = Color.LightGray,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .background(Color.DarkGray, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Form ${applicant.form} • ",
                    color = Color.LightGray,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text =  toSentenceCase(applicant.admissionStatus.name),
                    color = applicant.admissionStatus.color,
                    fontSize = 14.sp
                )

            }
        }

        Spacer(Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .border(0.dp, Color.Transparent, CircleShape)
        ) {
            Text(
                text = getFlagEmojiFor(getCountryCodeFromName(applicant.name)),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Center).fillMaxSize()
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More options",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
private fun PaymentStatusChip(status: PaymentStatus) {
    val (text, color) = when (status) {
        PaymentStatus.PAID -> "Paid" to Color(0xFF2ECC71)
        PaymentStatus.PARTIALLY_PAID -> "Partial" to Color(0xFFF39C12)
        PaymentStatus.UNPAID -> "Unpaid" to Color(0xFFE74C3C)
        PaymentStatus.OVERPAID -> "Overpaid" to Color(0xFF9B59B6)
    }

    Text(
        text = text,
        color = color,
        fontSize = 12.sp,
        modifier = Modifier
            .border(1.dp, color, RoundedCornerShape(4.dp))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

fun toSentenceCase(text: String): String {
    return text.toLowerCasePreservingASCIIRules()
        .replace('_', ' ')
        .replaceFirstChar { it.uppercase() }
}