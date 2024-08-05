package com.kashif.expense.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Adidas


@Composable
fun TransactionItem(
    icon: ImageVector = CssGgIcons.Adidas,
    date: String = "Today",
    amount: String = "- $13332",
    title: String = "Paypal",
) {

    Row(
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(50.dp),
                shape = MaterialTheme.shapes.medium,
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Icon(
                        icon,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }


            }
            Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(title, style = MaterialTheme.typography.titleSmall)
                Text(date, style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF666666)))
            }
        }

        Text(amount, style = MaterialTheme.typography.titleMedium.copy(color = Color(0xFF25A969)))

    }

}