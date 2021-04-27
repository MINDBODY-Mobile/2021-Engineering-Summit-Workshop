package com.mindbodyonline.workshop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.*
import com.mindbodyonline.workshop.ScreenRoute.Companion.ServiceDetailBaseRoute
import com.mindbodyonline.workshop.ScreenRoute.Companion.ServicesListRoute
import com.mindbodyonline.workshop.ScreenRoute.Companion.serviceDetail
import com.mindbodyonline.workshop.data.Repository
import com.mindbodyonline.workshop.data.model.ServiceId
import com.mindbodyonline.workshop.ui.ServiceDetail
import com.mindbodyonline.workshop.ui.ServiceList
import com.mindbodyonline.workshop.ui.presenter.ServiceDetailPresenter
import com.mindbodyonline.workshop.ui.presenter.ServiceListPresenter

inline class ScreenRoute(val route: String) {
    companion object {
        val ServicesListRoute = ScreenRoute("/list")
        val ServiceDetailBaseRoute = ScreenRoute("/details/{serviceId}")

        fun serviceDetail(id: ServiceId): ScreenRoute {
            return ScreenRoute(ServiceDetailBaseRoute.route.replace("{serviceId}", id.value))
        }
    }
}


@Composable
fun MyNavHost(repository: Repository, initialRoute: ScreenRoute? = null) {
    val navController = rememberNavController()
    val defaultRoute = ScreenRoute("/default")
    val startDestinationRoute = initialRoute?.let {
        defaultRoute
    } ?: ServicesListRoute
    NavHost(navController = navController, startDestination = startDestinationRoute.route) {
        composable(defaultRoute.route) {
            val dest = initialRoute?.route ?: ServicesListRoute.route
            navController.navigate(dest)
        }
        composable(ServicesListRoute.route) {
            val presenter = remember { ServiceListPresenter(repository) }
            val viewState by presenter.viewState()
            ServiceList(viewState, presenter::updateCategoryState) {
                navController.navigate(serviceDetail(it).route)
            }
        }
        composable(
            ServiceDetailBaseRoute.route,
            arguments = listOf(navArgument("serviceId") {})
        ) { backstackEntry ->
            val serviceId = backstackEntry.arguments?.getString("serviceId")?.let { ServiceId(it) }
            val presenter = remember(serviceId) { ServiceDetailPresenter(repository, serviceId) }
            val viewState by presenter.viewState()
            ServiceDetail(viewState) { navController.navigateUp() }
        }
    }
}