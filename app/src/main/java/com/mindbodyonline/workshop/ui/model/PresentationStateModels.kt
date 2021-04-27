package com.mindbodyonline.workshop.ui.model

import com.mindbodyonline.workshop.data.model.ServiceCategory


typealias ServiceCategoryState = Pair<ServiceCategory, Boolean>

val ServiceCategoryState.category get() = first
val ServiceCategoryState.selected get() = second

sealed class ServiceListViewState(val title: String) {
    object Placeholder : ServiceListViewState("Hello World")
}


sealed class ServiceDetailViewState(val title: String) {
    object NotFound : ServiceDetailViewState("Not Found")
}