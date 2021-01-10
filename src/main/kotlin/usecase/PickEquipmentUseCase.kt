package usecase

import Equipment
import EquipmentStatus.*
import game.rule.Rule
import Survivor
import game.rule.MaxEquipmentCapacityRule

class PickEquipmentUseCase {

    private val maxEquipmentCapacityRule: Rule = MaxEquipmentCapacityRule()

    fun execute(equipment: Equipment, survivor: Survivor) {
        if (!maxEquipmentCapacityRule.isComplied(survivor)) {
            return
        }
        checkIfItShouldBeCarriedInHand(survivor, equipment)
        survivor.pickEquipment(equipment)
    }

    private fun checkIfItShouldBeCarriedInHand(survivor: Survivor, equipment: Equipment) {
        if (shouldItCarriedInHand(survivor)) {
            equipment.status = IN_HAND
        } else {
            equipment.status = IN_RESERVE
        }
    }

    private fun shouldItCarriedInHand(survivor: Survivor): Boolean {
        return survivor.totalEquipmentCarriedInHands() < 2
    }
}