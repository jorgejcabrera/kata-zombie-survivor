package game.rule

import Survivor

class MaxEquipmentCapacityRule : Rule {

    private val maxSurvivorCapacity = 5

    override fun isComplied(survivor: Survivor): Boolean {
        val survivorCapacity = maxSurvivorCapacity - survivor.wounds
        return survivor.totalEquipmentCarried() < survivorCapacity
    }
}