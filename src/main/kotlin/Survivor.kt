import EquipmentStatus.IN_HAND

data class Survivor(
    val name: String,
    var wounds: Int,
    val equipment: MutableList<Equipment> = mutableListOf()
) {

    fun pickEquipment(equip: Equipment) {
        this.equipment.add(equip)
    }

    fun discardAnEquipment() {
        this.equipment.removeAt(0)
    }

    fun receiveWound() {
        this.wounds++
    }

    fun takeEquipment(equip: Equipment) {
        this.equipment.find { it == equip }?.let { it.status = IN_HAND }
    }

    fun isAlive(): Boolean {
        return this.wounds < 2
    }

    fun totalEquipmentCarriedInHands(): Int {
        return equipment.filter { it.status == IN_HAND }.size
    }

    fun totalEquipmentCarried(): Int {
        return equipment.size
    }
}