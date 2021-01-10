package game

class GameActionManagerAdapter : GameActionManager {
    override fun actionsPerTurn(): Int {
        return 3
    }
}