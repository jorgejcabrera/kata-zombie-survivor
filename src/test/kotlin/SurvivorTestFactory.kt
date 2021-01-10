import Survivor

class SurvivorTestFactory {

    companion object {
        fun common(): Survivor {
            return Survivor(name = "Jorge", wounds = 0)
        }

        fun createWithFiveItems(): Survivor {
            val equipment = mutableListOf(
                Pistol(),
                Molotov(),
                BottledWater(),
                FryingPan(),
                Katana()
            )
            return Survivor(
                name = "Jorge",
                wounds = 0,
                equipment = equipment
            )
        }

        fun createWithFourItems(): Survivor {
            val equipment = mutableListOf(
                Pistol(),
                Molotov(),
                BottledWater(),
                FryingPan()
            )
            return Survivor(
                name = "Jorge",
                wounds = 0,
                equipment = equipment
            )
        }
    }
}