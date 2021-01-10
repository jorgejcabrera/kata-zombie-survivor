import game.SurvivorActionManagerAdapter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SurvivorActionManagerTest {

    @Test
    fun `Each Survivor starts with the ability to perform 3 Actions per turn`() {
        // GIVEN
        val actionSurvivorManager = SurvivorActionManagerAdapter()

        // THEN
        assertEquals(3, actionSurvivorManager.actionsPerTurn())
    }
}