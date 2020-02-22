package azamat.kz.domain.executer

import io.reactivex.Scheduler

/**
 * Created by Asus on 05.11.2018.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}