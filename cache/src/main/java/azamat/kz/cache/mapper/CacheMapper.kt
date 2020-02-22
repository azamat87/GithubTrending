package azamat.kz.cache.mapper

/**
 * Created by Asus on 06.12.2018.
 */
interface CacheMapper<C, E> {

    fun mapFromCached(type: C): E

    fun mapToCached(type: E): C

}