package io.github.dagonco.sorteo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.dagonco.sorteo.common.normalize
import io.github.dagonco.sorteo.navidad.domain.model.SorteoNumberResult

@Composable
fun TicketListItem(ticket: SorteoNumberResult) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            modifier = Modifier.weight(1F),
            text = ticket.number.normalize(),
            style = MaterialTheme.typography.headlineLarge
        )
        Column(
            horizontalAlignment = Alignment.End
        ) {

            Row {
                Text(
                    text = "${ticket.bet} €",
                    style = MaterialTheme.typography.labelSmall
                )
            }

            Row {
                Text(
                    text = "${ticket.prize} €",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TicketListItemPreview() {
    val ticket = SorteoNumberResult(
        number = 5496,
        prize = 100,
    ).apply {
        bet = 20
    }
    TicketListItem(ticket)
}