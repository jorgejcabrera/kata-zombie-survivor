package usecase

import game.rule.Rule
import Survivor


class AttackSurvivorUseCase(private val maxEquipmentCapacityRule: Rule) {

    fun execute(victim: Survivor) {
        if (victim.isAlive()) {
            victim.receiveWound()
            checkIfSurvivorShouldDiscardAnEquipment(victim)
        }
    }

    private fun checkIfSurvivorShouldDiscardAnEquipment(victim: Survivor) {
        if (!maxEquipmentCapacityRule.isComplied(victim)) {
            victim.discardAnEquipment()
        }
    }
}