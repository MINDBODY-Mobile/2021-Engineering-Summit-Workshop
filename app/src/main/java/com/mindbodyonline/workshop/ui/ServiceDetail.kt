package com.mindbodyonline.workshop.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mindbodyonline.workshop.ui.theme.MyTheme


@Composable
fun ServiceDetail() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hello World!") },
            )
        }
    ) {
        Text("Hello World!")
    }
}

@Preview
@Composable
fun DetailPreview() {
    MyTheme {
        ServiceDetail()
    }
}