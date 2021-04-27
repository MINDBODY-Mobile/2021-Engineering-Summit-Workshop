package com.mindbodyonline.workshop.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindbodyonline.workshop.data.SampleData
import com.mindbodyonline.workshop.data.model.PriceOption
import com.mindbodyonline.workshop.data.model.Staff
import com.mindbodyonline.workshop.ui.model.ServiceDetailViewState
import com.mindbodyonline.workshop.ui.model.toAnnotatedStringList
import com.mindbodyonline.workshop.ui.theme.MyTheme
import kotlin.math.min

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
    val scrollState = rememberScrollState()
    Image(
        painter = painterResource(id = service.imageResourceId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .graphicsLayer {
                alpha = min(1f, 1 - (scrollState.value / 1000f))
                translationY = -scrollState.value * 0.3f
            }
    )
    Column(
        Modifier.verticalScroll(scrollState)
    ) {
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
        Spacer(Modifier.size(16.dp))
    }
}

@Composable
fun StaffListCard(staff: List<Staff>, modifier: Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = colors.surface,
        contentColor = colors.onSecondary,
        elevation = 2.dp,
        border = BorderStroke(
            width = 2.dp,
            brush = Brush.verticalGradient(
                0f to colors.secondary,
                1f to colors.secondaryVariant.copy(alpha = .5f)
            )
        )
    ) {

        Column {
            Text(
                "Available Staff",
                style = typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.secondary)
                    .padding(8.dp)
            )
            Spacer(Modifier.size(4.dp))
            staff.forEachIndexed { index, staffMember ->
                val backgroundColor = when {
                    index % 2 == 0 -> colors.secondary
                    else -> colors.secondaryVariant
                }
                Card(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    backgroundColor = backgroundColor,
                    contentColor = colors.onSecondary,
                    shape = RoundedCornerShape(percent = 50)
                ) {
                    Row(
                        Modifier.padding(2.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = staffMember.avatarResourceId),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(72.dp)
                                .clip(CircleShape)

                        )

                        Text(
                            staffMember.name,
                            style = typography.h6,
                            modifier = Modifier.padding(horizontal = 16.dp),
                            fontWeight = FontWeight.SemiBold
                        )

                    }
                    Spacer(Modifier.size(8.dp))
                }
            }
        }
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

        Column {
            Text(
                "Services",
                style = typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.primary)
                    .padding(8.dp)
            )
            Spacer(Modifier.height(8.dp))
            priceOptions.toAnnotatedStringList().forEach {
                Text(
                    text = it,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
            }
            Spacer(modifier = Modifier.size(4.dp))
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
        ServiceDetail(
            ServiceDetailViewState.Ready(
                SampleData.Services.therapeuticMassage,
                SampleData.StaffMembers.allStaff
            ),
            {}
        )
    }
}
