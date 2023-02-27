package io.github.dagonco.sorteo.navidad.api.request

import io.github.dagonco.sorteo.core.api.ApiRequest

abstract class SorteoNavidadApiRequest<Response : Any> : ApiRequest<Response>() {
    override val host: String = "api.elpais.com"
    override val path: String = "ws/LoteriaNavidadPremiados"
}