import EquipmentStatus.*

interface Equipment {
    var status: EquipmentStatus
}

data class Pistol(override var status: EquipmentStatus = IN_RESERVE) : Equipment

data class Molotov(override var status: EquipmentStatus = IN_RESERVE) : Equipment

data class FryingPan(override var status: EquipmentStatus = IN_RESERVE) : Equipment

data class BaseballBat(override var status: EquipmentStatus = IN_RESERVE) : Equipment

data class Katana(override var status: EquipmentStatus = IN_RESERVE) : Equipment

data class BottledWater(override var status: EquipmentStatus = IN_RESERVE) : Equipment

enum class EquipmentStatus {
    IN_HAND,
    IN_RESERVE
}