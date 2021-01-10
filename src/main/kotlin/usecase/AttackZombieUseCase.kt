package usecase

import Survivor

class AttackZombieUseCase {

    /** PRE: si el survivor ataca un zombie inmediatamente después lo mata. La definición de producto
    * no especifica nada sobre como se comporta la entidad zombie (hasta el step 4)
    * */
    fun execute(survivor: Survivor) {
        survivor.increaseExperience()
    }
}