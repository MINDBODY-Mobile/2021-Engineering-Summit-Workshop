package com.mindbodyonline.workshop.ui.presenter

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import com.mindbodyonline.workshop.data.Repository
import com.mindbodyonline.workshop.data.model.ServiceId
import com.mindbodyonline.workshop.ui.model.ServiceDetailViewState
import java.lang.IllegalStateException

fun interface GetServiceDetailViewState {
    fun viewState(): State<out ServiceDetailViewState>
}

class ServiceDetailPresenter(repo: Repository, serviceId: ServiceId?) : GetServiceDetailViewState {

    private val viewState: State<out ServiceDetailViewState> = derivedStateOf {
        if (serviceId == null) {
            ServiceDetailViewState.NotFound
        } else {
            try {
                val service = repo.service(serviceId)
                ServiceDetailViewState.Ready(
                    service,
                    repo.staffForCategory(service.categoryId)
                )
            } catch (e: IllegalStateException) {
                ServiceDetailViewState.NotFound
            }
        }
    }

    override fun viewState() = viewState
}