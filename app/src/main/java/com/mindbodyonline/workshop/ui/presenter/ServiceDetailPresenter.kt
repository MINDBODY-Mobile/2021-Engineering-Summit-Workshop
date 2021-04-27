package com.mindbodyonline.workshop.ui.presenter

import androidx.compose.runtime.State
import com.mindbodyonline.workshop.data.Repository
import com.mindbodyonline.workshop.data.model.ServiceId
import com.mindbodyonline.workshop.ui.model.ServiceDetailViewState

fun interface GetServiceDetailViewState {
    fun viewState(): State<out ServiceDetailViewState>
}

class ServiceDetailPresenter(repo: Repository, serviceId: ServiceId?) : GetServiceDetailViewState {

    private val viewState: State<out ServiceDetailViewState> = TODO("Not yet implemented")

    override fun viewState() = viewState
}