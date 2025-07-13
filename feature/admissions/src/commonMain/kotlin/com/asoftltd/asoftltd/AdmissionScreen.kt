package com.asoftltd.asoftltd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Business
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asoftltd.asoftltd.admission.AdmissionTopBars
import com.asoftltd.asoftltd.admission.ApplicantItem
import com.asoftltd.asoftltd.admission.AsAnimatedTabLayout
import com.asoftltd.asoftltd.admission.StatCard
import com.asoftltd.asoftltd.designsystem.Res
import com.asoftltd.asoftltd.designsystem.*
import com.asoftltd.asoftltd.designsystem.components.AsBackground
import com.asoftltd.asoftltd.designsystem.theme.AsTheme
import com.asoftltd.asoftltd.domain.model.AdmissionStats
import com.asoftltd.asoftltd.domain.model.Applicant
import com.asoftltd.asoftltd.domain.model.sampleApplicants
import org.jetbrains.compose.resources.DrawableResource
import kotlin.text.get

@Composable
fun AdmissionScreen() {
    AsBackground(
        topAppBar = {
            AdmissionTopBars(
                onSearchClick = {},
                onProfileClick = {},
                hasNotification = true,
                modifier = Modifier.padding(top = getStatusBarPadding().calculateTopPadding())
            )
        }
    ) {
        val stats = AdmissionStats(
            totalApplicants = 1145,
            admitted = 598,
            processed = 133,
            rejected = 47,
            trends = mapOf(
                "total" to 2.3,
                "admitted" to 8.5,
                "processed" to 34.2,
                "rejected" to 65.0
            )
        )

        val statsData = listOf(
            StatData(
                value = stats.totalApplicants.toString(),
                label = "Total Applicants",
                iconRes = Res.drawable.license,
                growth = stats.trends["total"] ?: 0.0,
                growthColor = Color(0xFF4CAF50)
            ),
            StatData(
                value = stats.admitted.toString(),
                label = "Admitted",
                iconRes = Res.drawable.user_check,
                growth = stats.trends["admitted"] ?: 0.0,
                growthColor = Color(0xFF2196F3)
            ),
            StatData(
                value = stats.processed.toString(),
                label = "Processed",
                iconRes = Res.drawable.user_story,
                growth = stats.trends["processed"] ?: 0.0,
                growthColor = Color(0xFFFF9800)
            ),
            StatData(
                value = stats.rejected.toString(),
                label = "Rejected",
                iconRes = Res.drawable.user_remove,
                growth = stats.trends["rejected"] ?: 0.0,
                growthColor = Color(0xFFF44336)
            )
        )

        val sampleOpportunities = listOf(
            "Scholarship Program",
            "Sports Recruitment",
            "Academic Exchange",
            "Early Admission"
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(statsData) { stat ->
                StatCard(stat)
            }

            // Tabbed content section
            item(span = { GridItemSpan(2) }) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = AsTheme.colors.secondary),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    AsAnimatedTabLayout(
                        tabItems = TabSelectType.entries,
                        modifier = Modifier.fillMaxWidth(),
                    ) { type ->
                        when (type) {
                            TabSelectType.APPLICANTS -> {
                                ApplicantsList(sampleApplicants)
                            }

                            TabSelectType.OPPORTUNITIES -> {
                                OpportunitiesList(
                                    opportunities = sampleOpportunities
                                )
                            }
                        }
                    }
                }

            }
        }
    }

}


@Composable
fun ApplicantsList(
    applicants: List<Applicant>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.heightIn(max = 400.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(applicants) { index, applicant ->
            ApplicantItem(applicant = applicant)
            if (index < applicants.lastIndex) {
                HorizontalDivider(
                    Modifier.padding(vertical = 4.dp),
                    1.dp,
                    Color.Gray.copy(alpha = 0.2f)
                )
            }
        }
    }
}

@Composable
fun OpportunitiesList(
    opportunities: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.heightIn(max = 400.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(opportunities) { opportunity ->
            OpportunityItem(opportunity = opportunity)
        }
    }
}

@Composable
fun OpportunityItem(opportunity: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D333D)
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Business,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = opportunity,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "View details",
                tint = Color.White
            )
        }
    }
}

enum class TabSelectType(type: String) {
    APPLICANTS(type = "Applicants"),
    OPPORTUNITIES(type = "Opportunities")
}



// Helper function to extract country code from name
fun getCountryCodeFromName(name: String): String {
    // This is a simplified approach - you might want to store country code in your Applicant data class
    return when {
        name.contains("Ndaki") -> "ke" // Tanzanian name
        name.contains("Mgonja") -> "tz" // Tanzanian name
        name.contains("Mwakalindila") -> "tz" // Tanzanian name
        name.contains("Mwinyi") -> "tz" // Tanzanian name
        name.contains("Sebastian") -> "ke" // Kenyan name
        name.contains("Abrahamani") -> "ug" // Ugandan name
        else -> "" // default
    }
}



class Country(
    val nameCode: String,
    val code: String,
    val fullName: String
)
fun getFlagEmojiFor(countryCode: String): String {
    return when (countryCode.lowercase()) {
        "cd" -> "🇨🇩"
        "ke" -> "🇰🇪"
        "rw" -> "🇷🇼"
        "ss" -> "🇸🇸"
        "tz" -> "🇹🇿"
        "ug" -> "🇺🇬"
        else -> " "
    }
}

fun getCountriesList(): List<Country> {
    val countries = mutableListOf<Country>()
    countries.add(Country("cd", "243", "Congo, The Democratic Republic Of The"))
    countries.add(Country("ke", "254", "Kenya"))
    countries.add(Country("rw", "250", "Rwanda"))
    countries.add(Country("ss", "211", "South Sudan"))
    countries.add(Country("tz", "255", "Tanzania, United Republic Of"))
    countries.add(Country("ug", "256", "Uganda"))
    return countries
}



data class StatData(
    val value: String,
    val label: String,
    val iconRes: DrawableResource,
    val growth: Double,
    val growthColor: Color
)
