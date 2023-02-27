package io.github.dagonco.sorteo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.dagonco.sorteo.common.normalize
import io.github.dagonco.sorteo.domain.Section
import io.github.dagonco.sorteo.navidad.viewmodel.SummaryViewModel
import io.github.dagonco.sorteo.ui.components.TopAppBar
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiveSummaryScreen(
    summaryViewModel: SummaryViewModel = koinViewModel(),
) {

    val summary = summaryViewModel.summary.collectAsState().value ?: return
    val lastUpdated = summaryViewModel.lastUpdated.collectAsState().value

    Scaffold(
        topBar = { TopAppBar(title = "Live Summary", actions = {}) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PrizeSection("FirstPrice", listOf(summary.firstPrizeNumber))
            PrizeSection("SecondPrice", listOf(summary.secondPrizeNumber))
            PrizeSection("ThirdPrice", listOf(summary.thirdPrizeNumber))
            PrizeSection("FourthPrice", listOf(summary.fourth1PrizeNumber, summary.fourth2PrizeNumber))
            PrizeSection(
                "FifthPrice",
                listOf(
                    summary.fifth1PrizeNumber,
                    summary.fifth2PrizeNumber,
                    summary.fifth3PrizeNumber,
                    summary.fifth4PrizeNumber,
                    summary.fifth5PrizeNumber,
                    summary.fifth6PrizeNumber,
                    summary.fifth7PrizeNumber,
                    summary.fifth8PrizeNumber
                )
            )

            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = "Last updated: $lastUpdated",
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun PrizeSection(title: String, number: List<Int>) {

    val gridColumns = if (number.size > 1) 2 else 1

    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(gridColumns),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(number) { number ->
                NumberBox(number = number)
            }
        }
    }
}

@Composable
private fun NumberBox(number: Int) {
    Text(
        text = number.normalize(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineLarge
    )
}


fun NavGraphBuilder.liveSummaryComposable() {
    composable(
        route = Section.Live.title,
    ) {
        LiveSummaryScreen()
    }
}

@Composable
@Preview
fun LiveSummaryScreenPreview() {
    LiveSummaryScreen()
}

@Composable
@Preview(showBackground = true)
private fun PrizeSectionPreview() {
    PrizeSection("Title", number = listOf(4938, 898))
}


@Composable
@Preview(showBackground = true)
private fun NumberBoxPreview() {
    NumberBox(number = 4596)
}
