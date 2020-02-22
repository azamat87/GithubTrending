package azamat.kz.mobile_ui.mapper

/**
 * Created by Asus on 10.12.2018.
 */
interface ViewMapper<in P, out V> {

    fun mapToView(presentation: P): V

}