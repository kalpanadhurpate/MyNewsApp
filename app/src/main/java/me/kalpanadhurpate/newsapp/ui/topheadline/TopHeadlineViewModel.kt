package me.kalpanadhurpate.newsapp.ui.topheadline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import me.kalpanadhurpate.newsapp.data.model.Article
import me.kalpanadhurpate.newsapp.data.repository.TopHeadlineRepository
import me.kalpanadhurpate.newsapp.ui.base.UiState
import me.kalpanadhurpate.newsapp.utils.AppConstant.COUNTRY

class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }.collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}