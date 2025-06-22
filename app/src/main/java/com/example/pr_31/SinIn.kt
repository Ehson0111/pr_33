package com.example.pr_31

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavController) {



    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp).padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Заголовок
        Text(
            text = "Привет!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Подзаголовок
        Text(
            text = "Заполните Свои Данные Или\nПродолжите Через Социальные Медиа",
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Разделитель
//        Divider(
//            modifier = Modifier.fillMaxWidth(),
//            thickness = 1.dp,
//            color = Color.LightGray
//        )

        Spacer(modifier = Modifier.height(24.dp))

        // Поле Email
        Text(
            text = "Email",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Поле Пароль
        Text(
            text = "Пароль",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Ссылка "Восстановить"
        TextButton(
            onClick = { /* TODO: Восстановление пароля */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Восстановить")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка "Войти"
        Button(
            onClick = {
                auth.signInWithEmailAndPassword(email.toString().trim(), password.toString().trim())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.navigate("home")
                        } else {
                            Toast.makeText(context, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Войти", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Ссылка "Создать пользователя"
        TextButton(
            onClick = { /* TODO: Регистрация */

            navController.navigate("home")},
            modifier = Modifier.fillMaxWidth().padding(top=150.dp)
        ) {
            Text(text = "Вы впервые? Создать пользователя")
        }
    }
}

