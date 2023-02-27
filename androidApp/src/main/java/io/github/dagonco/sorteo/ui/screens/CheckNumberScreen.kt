package io.github.dagonco.sorteo.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.dagonco.sorteo.domain.Section
import io.github.dagonco.sorteo.ui.components.TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckNumberScreen() {
    Scaffold(
        topBar = { TopAppBar(title = "Check Number", actions = {}) }
    ) {

    }
}

fun NavGraphBuilder.checkNumberComposable() {
    composable(
        route = Section.CheckNumber.title,
    ) {
        CheckNumberScreen()
    }
}


@Composable
@Preview
fun CheckNumberScreenPreview() {
    CheckNumberScreen()
}