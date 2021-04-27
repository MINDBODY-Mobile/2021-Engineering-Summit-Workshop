package com.mindbodyonline.workshop.ui.presenter

import androidx.compose.runtime.State
import com.mindbodyonline.workshop.data.Repository
import com.mindbodyonline.workshop.ui.model.ServiceCategoryState
import com.mindbodyonline.workshop.ui.model.ServiceListViewState

fun interface GetServiceListViewState {
    fun viewState(): State<out ServiceListViewState>
}

fun interface UpdateSelectedCategory {
    fun updateCategoryState(categoryState: ServiceCategoryState)
}

class ServiceListPresenter(repo: Repository) : GetServiceListViewState, UpdateSelectedCategory {

    private val viewState: State<out ServiceListViewState> = TODO("Not yet implemented")

    override fun viewState() = viewState

    override fun updateCategoryState(categoryState: ServiceCategoryState) {
        TODO("Not yet implemented")
    }
}