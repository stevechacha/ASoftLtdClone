package com.asoftltd.asoftltd.domain.model

data class AdmissionStats(
    val totalApplicants: Int,
    val admitted: Int,
    val processed: Int,
    val rejected: Int,
    val trends: Map<String, Double> // e.g., "week" to percentage change
)