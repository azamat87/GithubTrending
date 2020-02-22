package azamat.kz.data.mapper

/**
 * Created by Asus on 08.11.2018.
 */
interface EntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(domain: D): E

}