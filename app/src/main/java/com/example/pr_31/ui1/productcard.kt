package com.example.pr_31.ui1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pr_31.Product
import com.example.pr_31.R

@Composable
fun ProductCard(product: Product, onAddToCart: (Product) -> Unit) {
    Card(
        modifier = Modifier
            .size(width = 162.dp, height = 182.dp)
            .padding(16.dp),
        backgroundColor = colorResource(R.color.white),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(0.7f)) {
                Image(
                    painter = painterResource(R.drawable.nike),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = product.name,
                    modifier = Modifier.fillMaxSize()
                )

                IconButton(
                    onClick = { /* Toggle favorite */ },
                    modifier = Modifier
                        .size(28.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        painter = painterResource(R.drawable.iconwhite),
                        contentDescription = "Favorite"
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("₽${product.price_current ?: 0}.00", style = MaterialTheme.typography.h6)

                IconButton(onClick = { onAddToCart(product) }) {
                    Image(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "Add to Cart",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    }
}