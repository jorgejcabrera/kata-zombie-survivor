package usecase

import BaseballBat
import BottledWater
import EquipmentStatus
import Katana
import game.rule.MaxEquipmentCapacityRule
import SurvivorTestFactory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

internal class PickEquipmentUseCaseTest {

    private val pickEquipment = PickEquipmentUseCase()

    @Test
    fun `Each Survivor can carry up to 5 pieces of Equipment`() {
        // GIVEN
        val survivor = SurvivorTestFactory.createWithFiveItems()

        // WHEN
        pickEquipment.execute(BaseballBat(), survivor)

        // THEN
        assertFalse(survivor.equipment.contains(BaseballBat()))
    }

    @Test
    fun `Up to 2 pieces of carried Equipment are "In Hand", the rest are "In Reserve"`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // WHEN
        pickEquipment.execute(BaseballBat(), survivor)
        pickEquipment.execute(Katana(), survivor)
        pickEquipment.execute(BottledWater(), survivor)

        // THEN
        assertEquals(2, survivor.equipment.filter { it.status == EquipmentStatus.IN_HAND }.size)
    }

}