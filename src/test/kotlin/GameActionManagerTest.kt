import game.GameActionManagerAdapter
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameActionManagerTest {

    @Test
    fun `Each Survivor starts with the ability to perform 3 Actions per turn`() {
        // GIVEN
        val actionSurvivorManager = GameActionManagerAdapter()

        // THEN
        assertEquals(3, actionSurvivorManager.actionsPerTurn())
    }
}