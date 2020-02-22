package azamat.kz.cache.test.factory

import azamat.kz.cache.model.Config

/**
 * Created by Asus on 07.12.2018.
 */
object ConfigDataFactory {

    fun makeCachedConfig(): Config {
        return Config(DataFactory.randomLong())
    }

}