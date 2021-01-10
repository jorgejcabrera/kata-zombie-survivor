package game

import Level
import Level.*
import Survivor

class SurvivorLevelManager {
    fun level(survivor: Survivor): Level {
        return when {
            survivor.experience < 6 -> {
                BLUE
            }
            survivor.experience in 6..17 -> {
                YELLOW
            }
            survivor.experience in 17..41 -> {
                ORANGE
            }
            else -> {
                RED
            }
        }
    }
}