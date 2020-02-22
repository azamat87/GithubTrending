package azamat.kz.cache.test.factory

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by Asus on 07.12.2018.
 */
object DataFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    fun makeStringList(cont: Int): List<String> {
        val items = mutableListOf<String>()
        repeat(cont) {
            items.add(randomUuid())
        }
        return items
    }
}