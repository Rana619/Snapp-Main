package com.snapp.presentation.state

/** UI state for generic page screen. See ARCHITECTURE presentation/state/. */
sealed class PageUiState {
    data object Loading : PageUiState()
    data object Success : PageUiState()
    data class Error(val message: String) : PageUiState()
}
