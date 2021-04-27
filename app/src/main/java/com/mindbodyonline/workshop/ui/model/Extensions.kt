package com.mindbodyonline.workshop.ui.model

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.mindbodyonline.workshop.data.model.PriceOption
import com.mindbodyonline.workshop.data.model.Service
import java.text.NumberFormat


fun List<PriceOption>.toAnnotatedStringList(): List<AnnotatedString> =
    this.sortedBy { it.durationMinutes }
        .map {
            buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    append(it.durationPresentation)
                }
                append(" | ")
                append(it.pricePresentation)
            }
        }

val Service.priceRange: String
    get() {
        val prices = priceOptions
            .sortedBy { it.price }
            .map { it.pricePresentation }
        return when {
            prices.isEmpty() -> "Free!"
            prices.size == 1 -> prices.first()
            else -> "${prices.first()} - ${prices.last()}"
        }
    }

val Service.durationRange: String
    get() {
        val durations = priceOptions
            .sortedBy { it.durationMinutes }
            .map { it.durationPresentation }
        return when {
            durations.isEmpty() -> ""
            durations.size == 1 -> durations.first()
            else -> "${durations.first()} - ${durations.last()}"
        }
    }

val PriceOption.durationPresentation: String
    get() {
        val hours = durationMinutes / 60
        val minutes = durationMinutes % 60
        return when {
            hours > 0 && minutes > 0 -> "${hours}h ${minutes}m"
            hours > 0 && minutes <= 0 -> "${hours}h"
            else -> "${minutes}m"
        }
    }

val PriceOption.pricePresentation: String
    get() = NumberFormat.getCurrencyInstance()
        .also { formatter -> formatter.currency = currency }
        .format(price)
