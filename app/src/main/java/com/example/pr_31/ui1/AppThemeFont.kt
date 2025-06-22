package com.example.pr_31.ui1

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

@Composable
fun AppTheme(content: @Composable () -> Unit) {
//    val typography = Typography(defaultFontFamily = FontFamily(Font(R.))
//    )

    MaterialTheme(
//        typography = typography,
        content = content
    )
}