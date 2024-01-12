package com.orderapp.coffeemasters.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.orderapp.coffeemasters.DataManager
import com.orderapp.coffeemasters.ItemInCart
import com.orderapp.coffeemasters.Product
import com.orderapp.coffeemasters.ui.theme.CardBackground
import com.orderapp.coffeemasters.ui.theme.Primary


@Composable
fun OrderPage(dataManager: DataManager) {
    LazyColumn(){
        if (dataManager.cart.isEmpty()){
            item {
                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Cart is Empty")
                }
            }
        }
        items(dataManager.cart){ product ->
            CartItem(it = product, onDelete = {
                dataManager.cartRemove(it)
            })
        }
    }
}

@Composable
fun CartItem(it : ItemInCart, onDelete : (Product)->Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Text(text = "${it.quantity}x")
        Text(text = it.product.name)
        Text("$${(it.quantity*it.product.price).format(2)}")
        Image(imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            colorFilter = ColorFilter.tint(Primary),
            modifier = Modifier.clickable {
                onDelete(it.product)
            })
    }
}