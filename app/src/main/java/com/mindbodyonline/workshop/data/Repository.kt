package com.mindbodyonline.workshop.data

import com.mindbodyonline.workshop.data.model.ServiceCategoryId
import com.mindbodyonline.workshop.data.model.ServiceId

class Repository {

    fun categories() = SampleData.Categories.allCategories

    fun services() = SampleData.Services.allServices

    fun service(serviceId: ServiceId) =
        services().firstOrNull { it.id == serviceId } ?: error("Service $serviceId not found")

    fun staffForCategory(categoryId: ServiceCategoryId) = SampleData.StaffMembers.allStaff.filter {
        it.serviceCategories.contains(categoryId)
    }
}
