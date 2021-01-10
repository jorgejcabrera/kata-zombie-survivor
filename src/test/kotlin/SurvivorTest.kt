import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SurvivorTest {

    @Test
    fun `Each Survivor has a Name`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // THEN
        assertNotNull(survivor.name)
    }

    @Test
    fun `Each Survivor begins with 0 Wounds`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // THEN
        assertEquals(survivor.wounds, 0)
    }

}


