package com.mindbodyonline.workshop.ui.presenter

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.toMutableStateMap
import com.mindbodyonline.workshop.data.Repository
import com.mindbodyonline.workshop.ui.model.ServiceCategoryState
import com.mindbodyonline.workshop.ui.model.ServiceListViewState
import com.mindbodyonline.workshop.ui.model.category
import com.mindbodyonline.workshop.ui.model.selected

fun interface GetServiceListViewState {
    fun viewState(): State<out ServiceListViewState>
}

fun interface UpdateSelectedCategory {
    fun updateCategoryState(categoryState: ServiceCategoryState)
}

class ServiceListPresenter(repo: Repository) : GetServiceListViewState, UpdateSelectedCategory {
    private val categoryStates = repo.categories().map { it to true }.toMutableStateMap()
    private val viewState: State<out ServiceListViewState> = derivedStateOf {
        val categories = categoryStates.toList()
        ServiceListViewState.Ready(
            repo.services().filter { service ->
                categories.any { it.selected && it.category.id == service.categoryId }
            },
            categories
        )
    }

    override fun viewState() = viewState

    override fun updateCategoryState(categoryState: ServiceCategoryState) {
        categoryStates[categoryState.category] = categoryState.selected
    }
}