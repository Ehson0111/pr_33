package com.example.pr_31.ui1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pr_31.Category
import com.example.pr_31.R


@Composable
fun Slider(
    items: List<Category>,
    selectedCategory: Category,
    onItemSelected: (Category) -> Unit
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            items.forEach { category ->
                CategoryCard(
                    category = category,
                    selected = selectedCategory == category,
                    onCategorySelected = { selectedCategory ->
                        onItemSelected(selectedCategory)  // Передаём выбранную категорию
                    }
                )
            }
        }


}

@Composable
fun CategoryCard(category: Category, selected: Boolean, onCategorySelected: (Category) -> Unit) {
    Card(
        backgroundColor = if (selected)  colorResource(R.color.purple_700) else Color.White,
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
            .clickable {
                onCategorySelected(category)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = category.name,
            modifier = Modifier.padding(12.dp),
            fontSize = 16.sp,
            color = if (selected) Color.White else Color.Black,
        )
    }
}

