package usecase

import Equipment
import EquipmentStatus.*
import game.rule.Rule
import Survivor

class PickEquipmentUseCase(private val maxEquipmentCapacityRule: Rule) {

    fun execute(equipment: Equipment, survivor: Survivor) {
        if (!maxEquipmentCapacityRule.isComplied(survivor)) {
            return
        }
        if (shouldItCarriedInHand(survivor)) {
            equipment.status = IN_HAND
        } else {
            equipment.status = IN_RESERVE
        }
        survivor.pickEquipment(equipment)
    }

    private fun shouldItCarriedInHand(survivor: Survivor): Boolean {
        return survivor.totalEquipmentCarriedInHands() < 2
    }
}