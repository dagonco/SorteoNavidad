package io.github.dagonco.sorteo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import io.github.dagonco.sorteo.theme.MyApplicationTheme
import io.github.dagonco.sorteo.ui.NavigationGraph
import io.github.dagonco.sorteo.ui.components.BottomNavigationBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Screens()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Screens(

) {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigationBar(
            navController = navController,
        )
    }) {
        NavigationGraph(
            navController = navController
        )
    }
}
