package com.snapp.presentation.viewmodel

import com.snapp.presentation.state.PageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/** Shared VM for generic page. See ARCHITECTURE presentation/viewmodel/. */
class PageSharedViewModel {
    private val _pageUiState = MutableStateFlow<PageUiState>(PageUiState.Loading)
    val pageUiState: StateFlow<PageUiState> = _pageUiState.asStateFlow()
}
