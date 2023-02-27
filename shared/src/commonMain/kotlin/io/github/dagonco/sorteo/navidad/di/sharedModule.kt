package io.github.dagonco.sorteo.navidad.di

import io.github.dagonco.sorteo.core.api.ApiClient
import io.github.dagonco.sorteo.navidad.api.SorteoNavidadApiClient
import io.github.dagonco.sorteo.navidad.data.Repository
import io.github.dagonco.sorteo.navidad.data.source.NetworkDataSource
import io.github.dagonco.sorteo.navidad.data.source.StorageDataSource
import io.github.dagonco.sorteo.navidad.domain.GetLastUpdated
import io.github.dagonco.sorteo.navidad.domain.GetResult
import io.github.dagonco.sorteo.navidad.domain.GetStatus
import io.github.dagonco.sorteo.navidad.domain.GetSummary
import io.github.dagonco.sorteo.navidad.domain.RefreshStatus
import io.github.dagonco.sorteo.navidad.domain.RefreshSummary
import io.github.dagonco.sorteo.navidad.viewmodel.SummaryViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val apiModule = module {
    factoryOf(::SorteoNavidadApiClient)
    factoryOf(::ApiClient)
}

internal val dataModule = module {
    singleOf(::Repository)
    factoryOf(::NetworkDataSource)
    factoryOf(::StorageDataSource)
    factoryOf(::StorageDataSource)
}

internal val domainModule = module {
    factoryOf(::RefreshStatus)
    factoryOf(::GetStatus)
    factoryOf(::RefreshSummary)
    factoryOf(::GetSummary)
    factoryOf(::GetResult)
    factoryOf(::GetLastUpdated)
}

internal val viewModelModule = module {
    factoryOf(::SummaryViewModel)
}

val sharedModule = viewModelModule + domainModule + dataModule + apiModule
