package game

import Level.*
import SurvivorTestFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `A Game begins with 0 Survivors`() {
        // GIVEN
        val game = Game()

        // WHEN
        game.start()

        // THEN
        assertEquals(0, game.survivors.size)
    }

    @Test
    fun `A Game can have Survivors added to it at any time`() {
        // GIVEN
        val game = givenAGameWithASurvivorCalledJorge()

        // THEN
        assertEquals(1, game.survivors.size)
    }

    @Test
    fun `Survivor Names within a Game must be unique`() {
        // GIVEN
        val game = givenAGameWithASurvivorCalledJorge()
        val jorge = SurvivorTestFactory.common()

        // WHEN
        game.addSurvivor(jorge)

        // THEN
        assertEquals(1, game.survivors.size)

    }

    @Test
    fun `A Game ends immediately if all of its Survivors have died`() {
        // GIVEN
        val game = givenAGameWithASurvivorCalledJorge()

        // WHEN
        game.attackTo("Jorge")
        game.attackTo("Jorge")

        // THEN
        assertTrue(game.haveFinished())
    }

    @Test
    fun `A Game does not end when at least one survivor still be alive`() {
        // GIVEN
        val game = givenAGameWithASurvivorCalledJorge()

        // WHEN
        game.attackTo("Jorge")

        // THEN
        assertFalse(game.haveFinished())
    }

    @Test
    fun `A Game begins at Level Blue`() {
        // GIVEN
        val game = Game()

        //THEN
        assertEquals(BLUE, game.level())
    }

    @Test
    fun `A Game Level is always equal to the level of the highest living Survivor's Level`() {
        // GIVEN
        val game = Game()
        game.addSurvivor(SurvivorTestFactory.createWithSomeExperience())
        game.addSurvivor(SurvivorTestFactory.createWithToManyExperience())

        //THEN
        assertEquals(RED, game.level())
    }

    private fun givenAGameWithASurvivorCalledJorge(): Game {
        val game = Game()
        val jorge = SurvivorTestFactory.common()
        game.addSurvivor(jorge)
        return game
    }
}