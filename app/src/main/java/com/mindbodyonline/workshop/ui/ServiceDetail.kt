package com.mindbodyonline.workshop.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindbodyonline.workshop.data.SampleData
import com.mindbodyonline.workshop.data.model.PriceOption
import com.mindbodyonline.workshop.data.model.Staff
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
            is ServiceDetailViewState.Ready -> ServiceReady(viewState)
        }

    }
}

@Composable
fun ServiceReady(viewState: ServiceDetailViewState.Ready) {
    val service = viewState.service
    Image(
        painter = painterResource(id = service.imageResourceId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
    )
    Column() {
        Spacer(Modifier.height(180.dp))
        PricingOptionsCard(
            service.priceOptions,
            Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        StaffListCard(
            viewState.staff,
            Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun StaffListCard(staff: List<Staff>, modifier: Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = colors.surface,
        contentColor = colors.onSecondary,
        elevation = 2.dp
    ) {
        Text(
            "Available Staff",
            style = typography.h6,
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.secondary)
                .padding(8.dp)
        )
    }
}

@Composable
fun PricingOptionsCard(priceOptions: List<PriceOption>, modifier: Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = colors.primaryVariant,
        contentColor = colors.onPrimary,
        elevation = 2.dp
    ) {
        Text(
            "Services",
            style = typography.h6,
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.primary)
                .padding(8.dp)
        )
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
fun DetailPreview() {
    MyTheme {
        ServiceDetail(
            ServiceDetailViewState.Ready(
                SampleData.Services.therapeuticMassage,
                SampleData.StaffMembers.allStaff
            ),
            {}
        )
    }
}
