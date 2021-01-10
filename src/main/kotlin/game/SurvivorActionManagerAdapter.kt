package game

class SurvivorActionManagerAdapter : SurvivorActionManager {
    override fun actionsPerTurn(): Int {
        return 3
    }
}