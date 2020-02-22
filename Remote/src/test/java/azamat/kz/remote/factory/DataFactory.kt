package azamat.kz.remote.test.factory

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by Asus on 16.11.2018.
 */
object DataFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.50
    }

    fun randomInt(): Int{
        return ThreadLocalRandom.current().nextInt(0, 1000+1)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }

}