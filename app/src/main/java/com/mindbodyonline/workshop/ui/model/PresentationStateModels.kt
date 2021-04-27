package com.mindbodyonline.workshop.ui.model

import com.mindbodyonline.workshop.data.model.ServiceCategory


typealias ServiceCategoryState = Pair<ServiceCategory, Boolean>

val ServiceCategoryState.category get() = first
val ServiceCategoryState.selected get() = second

sealed class ServiceListViewState(val title: String) {
    object Placeholder : ServiceListViewState("Hello World")
//    data class Ready(
//        val services: List<Service>,
//        val categories: List<ServiceCategoryState>
//    ) : ServiceListViewState("Salon Services")
}


sealed class ServiceDetailViewState(val title: String) {
    object Placeholder : ServiceDetailViewState("Hello World")
//    data class Ready(
//        val service: Service,
//        val staff: List<Staff>
//    ) : ServiceDetailViewState(service.name)
//
//    object NotFound : ServiceDetailViewState("Not Found")
}