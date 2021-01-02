import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class NNNTest {

    @Test
    fun `Each Survivor has a Name`() {
        // GIVEN
        val survivor = givenASurvivor()

        // THEN
        assertNotNull(survivor.name)
    }

    @Test
    fun `Each Survivor begins with 0 Wounds`() {
        // GIVEN
        val survivor = givenASurvivor()

        // THEN
        assertEquals(survivor.wounds, 0)
    }

    @Test
    fun `Each Survivor starts with the ability to perform 3 Actions per turn`() {
        // GIVEN
        val actionSurvivorManager = ActionSurvivorManagerAdapter()

        // THEN
        assertEquals(3, actionSurvivorManager.actionsPerTurn())

    }

    private fun givenASurvivor(): Survivor {
        return Survivor(name = "Jorge", wounds = 0)
    }
}


