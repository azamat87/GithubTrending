package azamat.kz.presentation.mapper

/**
 * Created by Asus on 08.12.2018.
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}