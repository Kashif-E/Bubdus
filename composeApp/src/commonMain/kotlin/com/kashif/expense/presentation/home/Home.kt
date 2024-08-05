package com.kashif.expense.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kashif.expense.presentation.components.CategoryItem
import com.kashif.expense.presentation.components.IncomeCard
import com.kashif.expense.presentation.home.components.TransactionItem
import com.kashif.expense.theme.primaryLightWithTransparency
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Pen
import compose.icons.cssggicons.ShoppingCart
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

val categories = listOf(
    Pair("Shopping", CssGgIcons.ShoppingCart),
    Pair("Schooling", CssGgIcons.Pen),
    Pair("Shopping", CssGgIcons.ShoppingCart),
    Pair("Schooling", CssGgIcons.Pen),
    Pair("Shopping", CssGgIcons.ShoppingCart),
    Pair("Schooling", CssGgIcons.Pen),
    Pair("Shopping", CssGgIcons.ShoppingCart),
    Pair("Schooling", CssGgIcons.Pen)
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home() {
    val greetingMessage = remember { getGreetingMessage() }

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start,
            contentPadding = PaddingValues(0.dp)
        ) {
            stickyHeader { HeaderContent(greetingMessage) }
            item {
                DeckHeader(heading = "Transaction History") {

                }
            }
            items(4) { TransactionItem() }
            item {
                DeckHeader(heading = "Categories") {

                }
            }
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(categories) { item ->
                        CategoryItem(item.first, item.second, tint = MaterialTheme.colorScheme.primary) {
                        }

                    }
                }
            }
        }
    }
}

@Composable
private fun HeaderContent(greetingMessage: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
        CurvedBackground()
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 56.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TopBar(greetingMessage)
            IncomeCard {}
        }
    }
}

@Composable
private fun DeckHeader(heading: String, onSeeAll: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(heading, style = MaterialTheme.typography.titleSmall)
        Text(
            "See all",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.clickable {
                onSeeAll()
            })
    }
}

@Composable
private fun TopBar(greetingMessage: String) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = greetingMessage,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        Text(
            text = "Maryam Ajaz",
            style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
        )
    }
}

@Composable
private fun CurvedBackground() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomEnd = 60.dp,
            bottomStart = 60.dp
        ),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = primaryLightWithTransparency
        )
    ) {}
}

private fun getGreetingMessage(): String {
    val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val hour = currentTime.hour

    return when (hour) {
        in 5..11 -> "Good morning,"
        in 12..17 -> "Good afternoon,"
        in 18..21 -> "Good evening,"
        else -> "Good night,"
    }
}
