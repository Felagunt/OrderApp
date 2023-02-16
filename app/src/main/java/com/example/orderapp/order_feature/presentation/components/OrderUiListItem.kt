package com.example.orderapp.order_feature.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orderapp.order_feature.presentation.state.OrderListItem

@Composable
fun OrderUiListItem(
    orderListItem: OrderListItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                orderListItem.delivererName,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h6.fontSize
            )
            Text(
                "%.2f".format(orderListItem.totalAmount)+ " $",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h6.fontSize
            )
        }
        Divider(color = MaterialTheme.colors.primary)
        Box(
            modifier = modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                orderListItem.orderDate,
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            )
        }
    }
}