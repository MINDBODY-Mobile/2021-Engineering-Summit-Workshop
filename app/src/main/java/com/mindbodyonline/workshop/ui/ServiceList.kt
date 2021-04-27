package com.mindbodyonline.workshop.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

}

@Preview
@Composable
fun ListPreview() {
    MyTheme {
        ServiceList(ServiceListViewState.Placeholder, {}, {})
    }
}