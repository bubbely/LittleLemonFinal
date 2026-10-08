package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            LittleLemonTheme {
                MainView()
            }
            }
        }
    }


@Composable
fun MainView() {
    val navController = rememberNavController()
    // Determine startDestination based on user login status
    // val startDestination = if (userIsLoggedIn()) "Home" else "Onboarding"
    val context = LocalContext.current
    NavComposable(context = context,navController = navController)

}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    LittleLemonTheme {
        MainView()
    }
}