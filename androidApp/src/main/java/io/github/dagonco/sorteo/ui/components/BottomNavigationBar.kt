package io.github.dagonco.sorteo.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.dagonco.sorteo.domain.Section.CheckNumber
import io.github.dagonco.sorteo.domain.Section.Live

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val sections = listOf(Live, CheckNumber)

    NavigationBar {
        sections.forEachIndexed { index, section ->
            NavigationBarItem(
                label = { Text(section.title) },
                icon = {
                    Icon(
                        modifier = Modifier.height(28.dp),
                        painter = painterResource(id = section.icon),
                        contentDescription = null,
                    )
                },
                selected = navBackStackEntry?.destination?.route == section.title,
                onClick = {
                    navController.navigate(sections[index].title) {
                        popUpTo(Live.title)
                    }
                }
            )
        }
    }
}


@Composable
@Preview
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}