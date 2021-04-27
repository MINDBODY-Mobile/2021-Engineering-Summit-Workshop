package com.mindbodyonline.workshop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mindbodyonline.workshop.ui.model.ServiceDetailViewState
import com.mindbodyonline.workshop.ui.theme.MyTheme

@Composable
fun ServiceDetail(viewState: ServiceDetailViewState, navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(viewState.title) },
            )
        }
    ) {
        when (viewState) {
            ServiceDetailViewState.NotFound -> ServiceNotFound()
        }

    }
}

@Composable
private fun ServiceNotFound() {
    Box(
        Modifier
            .fillMaxSize()
            .background(colors.surface),
        contentAlignment = Alignment.Center,
    ) {
        Text("We couldn't find that service.")
    }
}

@Preview
@Composable
fun DetailPreview(darkTheme: Boolean = false) {
    MyTheme(darkTheme) {
        ServiceDetail(ServiceDetailViewState.NotFound, {})
    }
}
