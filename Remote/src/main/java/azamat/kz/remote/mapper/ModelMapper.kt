package azamat.kz.remote.mapper

/**
 * Created by Asus on 16.11.2018.
 */
interface ModelMapper<in M, out E> {

    fun mapFromModel(model: M): E

}