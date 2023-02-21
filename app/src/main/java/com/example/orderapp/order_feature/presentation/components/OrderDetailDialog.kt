package com.example.orderapp.order_feature.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.orderapp.order_feature.presentation.OrderViewModel
import com.example.orderapp.order_feature.presentation.state.OrderDetailListItem

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OrderDetailDialog(
    onDismiss: () -> Unit,
    orderDetailListItem: OrderDetailListItem
) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.8f)
                .border(
                    1.dp,
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    Text(
                        "Ordered from ${orderDetailListItem.delivererName}",
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        orderDetailListItem.orderDate,
                        fontSize = MaterialTheme.typography.subtitle2.fontSize,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp)
                    )
                    Divider(modifier = Modifier.padding(top = 10.dp))
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        modifier = Modifier
                            .padding(top = 15.dp)
                    ) {
                        items(
                            orderDetailListItem.products,
                            key = { productListItem ->
                                productListItem.id
                            }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "${it.selectedAmount}x " + it.name
                                )
                                Text(
                                    "%.2f".format(it.pricePerAmount * it.selectedAmount) + " $"
                                )
                            }
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Divider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Total sum",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "%.2f".format(
                                orderDetailListItem.products
                                    .sumOf {
                                        (it.selectedAmount * it.pricePerAmount).toDouble()
                                    }
                            ) + " $",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}