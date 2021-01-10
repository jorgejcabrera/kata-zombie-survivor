package game

import Level.*
import SurvivorTestFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SurvivorLevelManagerTest {

    private val survivorLevelManager = SurvivorLevelManager()

    @Test
    fun `Each Survivor has a current Level`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // THEN
        assertNotNull(survivorLevelManager.level(survivor))
    }

    @Test
    fun `Each Survivor begins at Level Blue`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // THEN
        assertEquals(BLUE, survivorLevelManager.level(survivor))
    }
}