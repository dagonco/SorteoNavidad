package io.github.dagonco.sorteo.navidad.viewmodel

import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.github.dagonco.sorteo.navidad.domain.GetLastUpdated
import io.github.dagonco.sorteo.navidad.domain.GetSummary
import io.github.dagonco.sorteo.navidad.domain.RefreshStatus
import io.github.dagonco.sorteo.navidad.domain.RefreshSummary
import io.github.dagonco.sorteo.navidad.domain.model.SorteoSummary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class SummaryViewModel(
    getSummary: GetSummary,
    getLastUpdated: GetLastUpdated,
    private val refreshStatus: RefreshStatus,
    private val refreshSummary: RefreshSummary,
) : ViewModel() {

    private val _summary: MutableStateFlow<SorteoSummary?> = MutableStateFlow(null)

    val summary: CStateFlow<SorteoSummary?> = getSummary().filterNotNull().stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        _summary.value
    ).cStateFlow()


    private val _lastUpdated: MutableStateFlow<String> = MutableStateFlow("")
    val lastUpdated: CStateFlow<String> = getLastUpdated().map {
        Instant
            .fromEpochSeconds(it.timestamp.toLong())
            .toLocalDateTime(TimeZone.currentSystemDefault()).toString()
    }.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        _lastUpdated.value
    ).cStateFlow()

    init {
        viewModelScope.launch {
            refreshStatus()
            refreshSummary()
        }
    }
}