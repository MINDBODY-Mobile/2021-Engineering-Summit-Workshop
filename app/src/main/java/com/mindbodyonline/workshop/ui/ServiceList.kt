package com.mindbodyonline.workshop.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindbodyonline.workshop.data.SampleData
import com.mindbodyonline.workshop.data.model.Service
import com.mindbodyonline.workshop.data.model.ServiceId
import com.mindbodyonline.workshop.ui.model.ServiceCategoryState
import com.mindbodyonline.workshop.ui.model.ServiceListViewState
import com.mindbodyonline.workshop.ui.theme.MyTheme


@Composable
fun ServiceList(
    viewState: ServiceListViewState,
    onCategorySelectionChanged: (ServiceCategoryState) -> Unit,
    navigateToDetail: (ServiceId) -> Unit
) {
    BottomSheetScaffold(
        sheetContent = { Text("Hello Bottom Sheet") },
        topBar = {
            TopAppBar(
                title = { Text(viewState.title) },
                navigationIcon = {
                    Icon(
                        Icons.Default.Spa,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )
        },
        sheetBackgroundColor = colors.secondaryVariant,
        sheetPeekHeight = 0.dp,
        sheetElevation = 4.dp,
        sheetShape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp)
    ) {
        val services = when (viewState) {
            ServiceListViewState.Placeholder -> emptyList()
            is ServiceListViewState.Ready -> viewState.services
        }

        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 180.dp),
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(4.dp),
        ) {
            items(services) { service ->
                ServiceItemCard(service, navigateToDetail)
            }

        }
    }
}

@Composable
fun ServiceItemCard(service: Service, navigateToDetail: (ServiceId) -> Unit) {
    Card() {
        Image(
            painter = painterResource(id = service.imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
    }
}

@Preview
@Composable
fun ListPreview() {
    MyTheme {
        ServiceList(ServiceListViewState.Ready(
            SampleData.Services.allServices,
            SampleData.Categories.allCategories.map { it to true }
        ), {}, {})
    }
}
