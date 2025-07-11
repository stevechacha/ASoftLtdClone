package com.asoftltd.asoftltd.model

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdmissionViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AdmissionUiState())
    val uiState: StateFlow<AdmissionUiState> = _uiState


    init {
        loadInitialData()
    }

    fun loadInitialData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val stats = sampleAdmissionStats
                val applicants = sampleApplicants
                _uiState.value = _uiState.value.copy(
                    stats = stats,
                    applicants = applicants,
                    isLoading = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }

    fun loadMoreApplicants() {
        if (_uiState.value.isLoadingMore) return
        
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoadingMore = true)
            try {
                val newApplicants = sampleApplicants
                _uiState.value = _uiState.value.copy(
                    applicants = _uiState.value.applicants + newApplicants,
                    isLoadingMore = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = e.message,
                    isLoadingMore = false
                )
            }
        }
    }
}

data class AdmissionUiState(
    val stats: AdmissionStats? = null,
    val applicants: List<Applicant> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val error: String? = null
)