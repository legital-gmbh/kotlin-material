package org.legital.kotlin.rockpaperscissors.strategy

import org.legital.kotlin.rockpaperscissors.GameElement

interface ChoosingStrategy {
    fun choose(): GameElement
}
