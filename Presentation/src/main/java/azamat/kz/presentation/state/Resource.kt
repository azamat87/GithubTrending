package azamat.kz.presentation.state

/**
 * Created by Asus on 08.12.2018.
 */
class Resource<out T> constructor(val status: ResourceState,
                                  val data: T?,
                                  val message: String?)