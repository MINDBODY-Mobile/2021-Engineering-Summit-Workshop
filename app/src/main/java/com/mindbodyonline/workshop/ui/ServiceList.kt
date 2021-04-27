package com.mindbodyonline.workshop.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        sheetPeekHeight = 120.dp,
        sheetElevation = 4.dp,
        sheetShape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp)
    ) {
        Text("Hello World")
    }
}

@Preview
@Composable
fun ListPreview() {
    MyTheme {
        ServiceList(ServiceListViewState.Placeholder, {}, {})
    }
}
