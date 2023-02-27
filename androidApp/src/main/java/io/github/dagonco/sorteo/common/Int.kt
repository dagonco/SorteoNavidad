package io.github.dagonco.sorteo.common

fun Int.normalize(): String =
    toString().padStart(5, '0')