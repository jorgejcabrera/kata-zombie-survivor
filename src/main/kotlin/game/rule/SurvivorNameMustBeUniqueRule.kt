package game.rule

import Survivor

class SurvivorNameMustBeUniqueRule(var names: List<String> = emptyList()) : Rule {

    override fun isComplied(survivor: Survivor): Boolean {
        return names.none { it == survivor.name }
    }
}