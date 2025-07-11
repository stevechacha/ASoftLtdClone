package com.asoftltd.asoftltd.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calendar
import kotlinx.datetime.LocalDate
import kotlin.random.Random
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime

data class Applicant(
    val id: String = Random.toString(),
    val name: String,
    val countryCode: String,
    val form: String,
    val paymentStatus: PaymentStatus,
    val admissionStatus: AdmissionStatus,
    val applicationDate: String = generateRandomDate(),
    val profileImage: String? = null
)

enum class PaymentStatus(val displayName: String, val color: Color) {
    PAID("Paid", Color(0xFF2ECC71)),
    PARTIALLY_PAID("Partial", Color(0xFFF39C12)),
    UNPAID("Unpaid", Color(0xFFE74C3C)),
    OVERPAID("Overpaid", Color(0xFF9B59B6))
}

enum class AdmissionStatus(val displayName: String, val color: Color) {
    ADMITTED("Admitted", Color(0xFF2ECC71)),
    REJECTED("Rejected", Color(0xFFE74C3C)),
    PROCESSED("Processed", Color(0xFF3498DB)),
    UNPROCESSED("Unprocessed", Color(0xFFF39C12))
}

private fun generateRandomDate(): String {
    val now = Clock.System.now()
    val today = now.toLocalDateTime(TimeZone.currentSystemDefault()).date

    val randomDaysAgo = Random.nextInt(365)
    val randomDate = today.minus(randomDaysAgo, DateTimeUnit.DAY)

    return randomDate.toString(format = "dd MMM yyyy")
}

fun LocalDate.toString(format: String): String {
    return when (format) {
        "dd MMM yyyy" -> {
            val day = dayOfMonth.toString().padStart(2, '0')
            val month = when (monthNumber) {
                1 -> "Jan"
                2 -> "Feb"
                3 -> "Mar"
                4 -> "Apr"
                5 -> "May"
                6 -> "Jun"
                7 -> "Jul"
                8 -> "Aug"
                9 -> "Sep"
                10 -> "Oct"
                11 -> "Nov"
                12 -> "Dec"
                else -> ""
            }
            "$day $month $year"
        }
        else -> toString()
    }
}
fun getFlagEmoji(countryCode: String): String {
    return when (countryCode.lowercase()) {
        "tz" -> "🇹🇿" // Tanzania
        "ke" -> "🇰🇪" // Kenya
        "ug" -> "🇺🇬" // Uganda
        "rw" -> "🇷🇼" // Rwanda
        "zm" -> "🇿🇲" // Zambia
        "ss" -> "🇸🇸" // South Sudan
        "cd" -> "🇨🇩" // DR Congo
        "mw" -> "🇲🇼" // Malawi
        "et" -> "🇪🇹" // Ethiopia
        else -> "🌍"
    }
}

val sampleApplicants = listOf(
    Applicant(
        name = "Emmanuel Ndaki",
        countryCode = "tz",
        form = "I",
        paymentStatus = PaymentStatus.PAID,
        admissionStatus = AdmissionStatus.REJECTED
    ),
    Applicant(
        name = "Pendo Mwakalindila",
        countryCode = "tz",
        form = "I",
        paymentStatus = PaymentStatus.OVERPAID,
        admissionStatus = AdmissionStatus.PROCESSED
    ),
    Applicant(
        name = "Ibrahim Mwinyi",
        countryCode = "tz",
        form = "I",
        paymentStatus = PaymentStatus.UNPAID,
        admissionStatus = AdmissionStatus.UNPROCESSED
    ),
    Applicant(
        name = "Salha Abrahamani",
        countryCode = "ug",
        form = "I",
        paymentStatus = PaymentStatus.PAID,
        admissionStatus = AdmissionStatus.ADMITTED
    ),
    Applicant(
        name = "Grace Nkunda",
        countryCode = "rw",
        form = "I",
        paymentStatus = PaymentStatus.PARTIALLY_PAID,
        admissionStatus = AdmissionStatus.PROCESSED
    ),

    // Form II Applicants
    Applicant(
        name = "Edwin Mgonja",
        countryCode = "tz",
        form = "II",
        paymentStatus = PaymentStatus.PARTIALLY_PAID,
        admissionStatus = AdmissionStatus.ADMITTED
    ),
    Applicant(
        name = "Diana Kamau",
        countryCode = "ke",
        form = "II",
        paymentStatus = PaymentStatus.PAID,
        admissionStatus = AdmissionStatus.ADMITTED
    ),
    Applicant(
        name = "Frank Mwamba",
        countryCode = "zm",
        form = "II",
        paymentStatus = PaymentStatus.UNPAID,
        admissionStatus = AdmissionStatus.REJECTED
    ),

    Applicant(
        name = "John Sebastian",
        countryCode = "ke",
        form = "III",
        paymentStatus = PaymentStatus.PAID,
        admissionStatus = AdmissionStatus.ADMITTED
    ),
    Applicant(
        name = "Sarah Mwangi",
        countryCode = "ke",
        form = "III",
        paymentStatus = PaymentStatus.PAID,
        admissionStatus = AdmissionStatus.PROCESSED
    ),
    Applicant(
        name = "Michael Ochieng",
        countryCode = "ke",
        form = "IV",
        paymentStatus = PaymentStatus.PAID,
        admissionStatus = AdmissionStatus.ADMITTED
    ),
    Applicant(
        name = "Lilian Nalubega",
        countryCode = "ug",
        form = "I",
        paymentStatus = PaymentStatus.PARTIALLY_PAID,
        admissionStatus = AdmissionStatus.PROCESSED
    ),
).sortedBy { it.name }

val sampleAdmissionStats = AdmissionStats(
    totalApplicants = 1145,
    admitted = 598,
    processed = 33,
    rejected = 47,
    trends = mapOf(
        "total" to 2.3,
        "admitted" to 8.5,
        "processed" to -34.0,
        "rejected" to 65.0
    )
)