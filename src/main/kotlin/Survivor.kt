import EquipmentStatus.IN_HAND
import game.rule.SurvivorMustDiedRule

data class Survivor(
    val name: String,
    var wounds: Int,
    internal val equipment: MutableList<Equipment> = mutableListOf()
) {
    private val mustDieRule = SurvivorMustDiedRule()

    fun pickEquipment(equip: Equipment) {
        this.equipment.add(equip)
    }

    fun discardAnEquipment() {
        this.equipment.removeAt(0)
    }

    fun receiveWound() {
        this.wounds++
    }

    fun isAlive(): Boolean {
        return !mustDieRule.isComplied(this)
    }

    fun totalEquipmentCarriedInHands(): Int {
        return equipment.filter { it.status == IN_HAND }.size
    }

    fun totalEquipmentCarried(): Int {
        return equipment.size
    }
}