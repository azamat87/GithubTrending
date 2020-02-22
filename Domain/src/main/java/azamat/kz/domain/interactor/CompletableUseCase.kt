package azamat.kz.domain.interactor

import azamat.kz.domain.executer.PostExecutionThread
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Asus on 05.11.2018.
 */
abstract class CompletableUseCase<in Params> constructor(
        private val postExecutionThread: PostExecutionThread){

    private val compositeDisposable = CompositeDisposable()

    abstract fun buildsUseCaseCompletable(params: Params? = null): Completable

    open fun execute(observer: DisposableCompletableObserver, params: Params? = null){
        val completable = this.buildsUseCaseCompletable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
        addDisposable(completable.subscribeWith(observer))
    }

    fun dispose() {
        compositeDisposable.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}