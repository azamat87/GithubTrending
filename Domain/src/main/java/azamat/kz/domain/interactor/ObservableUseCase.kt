package azamat.kz.domain.interactor

import azamat.kz.domain.executer.PostExecutionThread
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Asus on 05.11.2018.
 */
abstract class ObservableUseCase<T, in Params> constructor(
        private val postExecutionThread: PostExecutionThread){

    private val compositeDisposable = CompositeDisposable()

    abstract fun buildsUseCaseObservable(params: Params? = null): Observable<T>

    open fun execute(observer: DisposableObserver<T>, params: Params? = null){
        val observable = this.buildsUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        compositeDisposable.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}