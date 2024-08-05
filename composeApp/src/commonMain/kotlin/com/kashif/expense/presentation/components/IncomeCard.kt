package com.kashif.expense.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.icons.CssGgIcons
import compose.icons.cssggicons.ArrowDown
import compose.icons.cssggicons.ArrowUp
import compose.icons.cssggicons.MenuRight


@Composable
fun IncomeCard(totalBalance: String = "$2,548.99", onMenuClick: () -> Unit = {}) {

    Card(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.large,
    ) {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary).padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    "Total Balance",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Icon(CssGgIcons.MenuRight, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimary)

            }

            Text(totalBalance, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onPrimary)

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IncomeRow(
                    modifier = Modifier.weight(1f),
                    heading = "Income",
                    balance = totalBalance,
                    icon = CssGgIcons.ArrowDown
                )
                IncomeRow(
                    modifier = Modifier.weight(1f),
                    heading = "Expenses",
                    balance = "$2333",
                    icon = CssGgIcons.ArrowUp,
                    alignment = Alignment.End
                )
            }

        }
    }

}

@Composable
private fun IncomeRow(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start,
    heading: String,
    balance: String,
    icon: ImageVector
) {
    Column(
        modifier = modifier, horizontalAlignment = alignment, verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.width(24.dp).height(24.dp)
                    .background(color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.25f), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp), tint = MaterialTheme.colorScheme.onPrimary)
            }
            Text(heading, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onPrimary)
        }

        Text(balance, style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onPrimary)
    }

}