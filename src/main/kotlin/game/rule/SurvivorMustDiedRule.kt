package game.rule

import Survivor

class SurvivorMustDiedRule : Rule {
    override fun isComplied(survivor: Survivor): Boolean {
        return survivor.wounds >= 2
    }
}