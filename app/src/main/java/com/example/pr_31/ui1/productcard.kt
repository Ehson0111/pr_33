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
import coil.compose.rememberAsyncImagePainter
import com.example.pr_31.Product
import com.example.pr_31.R

@Composable
fun ProductCard(product: Product) {
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

                IconButton(
                    onClick = { /* Toggle favorite */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        modifier=Modifier.size(28.dp),
                        painter = painterResource(R.drawable.iconwhite),
                        contentDescription = "Favorite"
                    )
                }
                Image(
                    painter = painterResource(R.drawable.nike),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = product.name,
                    modifier = Modifier.fillMaxSize()
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("₽${product.price_current}.00", style = MaterialTheme.typography.h6)

                IconButton(onClick = { /* Add to cart */ }) {
                    Image(

                        modifier = Modifier.size(28.dp),
                        painter = painterResource(R.drawable.plus),
                        contentDescription = "Add to Cart"
                    )
                }
            }
        }
    }
}