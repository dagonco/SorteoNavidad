package io.github.dagonco.sorteo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import io.github.dagonco.sorteo.domain.Section
import io.github.dagonco.sorteo.ui.screens.checkNumberComposable
import io.github.dagonco.sorteo.ui.screens.liveSummaryComposable

@Composable
fun NavigationGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = "navigation-graph",
    ) {

        navigation(
            startDestination = Section.Live.title,
            route = "navigation-graph"
        ) {
            liveSummaryComposable()
            checkNumberComposable()
        }
    }
}
