package game

import Level
import Survivor
import game.rule.SurvivorNameMustBeUniqueRule
import usecase.AttackSurvivorUseCase
import java.lang.RuntimeException

class Game(val survivors: MutableList<Survivor> = mutableListOf()) {

    private val survivorNameMustBeUniqueRule: SurvivorNameMustBeUniqueRule = SurvivorNameMustBeUniqueRule()

    fun start() {
        this.survivors.clear()
    }

    fun addSurvivor(survivor: Survivor) {
        survivorNameMustBeUniqueRule.names = this.survivors.map { it.name }
        if (survivorNameMustBeUniqueRule.isComplied(survivor)) {
            this.survivors.add(survivor)
        }
    }

    fun attackTo(survivorName: String) {
        val survivor = this.survivors.find { it.name == survivorName }
            ?: throw RuntimeException("Survivor $survivorName was not found.")
        AttackSurvivorUseCase().execute(survivor)
    }

    fun haveFinished(): Boolean {
        if (this.survivors.isEmpty()) return false
        return this.survivors.none { it.isAlive() }
    }

    fun level(): Level {
        val bestSurvivor = this.survivors.maxBy { it.experience } ?: return Level.BLUE
        return SurvivorLevelManager().level(bestSurvivor)
    }
}