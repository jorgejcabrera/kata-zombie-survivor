package usecase

import Katana
import game.rule.MaxEquipmentCapacityRule
import SurvivorTestFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AttackSurvivorUseCaseTest {

    private val attackSurvivor = AttackSurvivorUseCase()
    private val pickEquipment = PickEquipmentUseCase()

    @Test
    fun `A Survivor who receives 2 Wounds dies immediately additional Wounds are ignored`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // WHEN
        attackSurvivor.execute(survivor)
        attackSurvivor.execute(survivor)
        attackSurvivor.execute(survivor)

        // THEN
        assertFalse(survivor.isAlive())
        assertEquals(2, survivor.wounds)
    }

    @Test
    fun `A Survivor who receives 1 Wounds must be alive`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // WHEN
        attackSurvivor.execute(survivor)

        // THEN
        assertTrue(survivor.isAlive())
    }

    @Test
    fun `Each Wound a Survivor receives reduces the number of pieces of Equipment they can carry by 1`() {
        // GIVEN
        val survivor = SurvivorTestFactory.createWithFourItems()

        // WHEN
        attackSurvivor.execute(survivor)
        pickEquipment.execute(Katana(), survivor)

        // THEN
        assertEquals(4, survivor.totalEquipmentCarried())
    }

    @Test
    fun `If the Survivor has more Equipment than their new capacity, choose a piece to discard (implement however you like)`() {
        // GIVEN
        val survivor = SurvivorTestFactory.createWithFiveItems()

        // WHEN
        attackSurvivor.execute(survivor)

        // THEN
        assertEquals(4, survivor.totalEquipmentCarried())
    }
}