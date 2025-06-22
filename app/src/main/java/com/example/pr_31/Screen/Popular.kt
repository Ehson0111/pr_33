package com.example.pr_31.Screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr_31.Product
import com.example.pr_31.R
import com.example.pr_31.ui1.ProductCard

@Composable
fun AllProductsScreen(navController: NavController, products: List<Product>) {

    Column(modifier = Modifier.padding(top = 22.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {


            IconButton(onClick = { /* Избранное */ }) {
                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = "Избранное",
                    tint = Color.Gray, modifier = Modifier.size(44.dp)
                )
            }

            Text(
                "Популярное",
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 22.dp)
            )

            IconButton(onClick = { /* Избранное */ }) {
                Icon(

                    modifier = Modifier.size(44.dp),
                    painter = painterResource(R.drawable.like),
                    contentDescription = "Избранное",
                    tint = Color.Gray
                )
            }


        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp)
        ) {
            items(products.filterNotNull()) { product ->

                ProductCard(product = product)
            }
        }
    }
}


