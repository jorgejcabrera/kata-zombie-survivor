package game.rule

import Survivor

interface Rule {
    fun isComplied(survivor: Survivor): Boolean
}