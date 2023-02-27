package io.github.dagonco.sorteo.domain

import io.github.dagonco.sorteo.R

open class Section(val title: String, val icon: Int) {
    object Live : Section(
        title = "Live",
        icon = R.drawable.icn_summary
    )

    object CheckNumber : Section(
        title = "Search",
        icon = R.drawable.icn_search_check
    )
}
