package usecase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AttackZombieUseCaseTest {

    private val attackZombie = AttackZombieUseCase()

    @Test
    fun `Each time the Survivor kills a zombie, they can 1 Experience`() {
        // GIVEN
        val survivor = SurvivorTestFactory.common()

        // WHEN
        attackZombie.execute(survivor)

        // THEN
        assertEquals(1, survivor.experience)

    }
}