package azamat.kz.mobile_ui.test

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.test.runner.AndroidJUnitRunner
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers

/**
 * Created by Asus on 15.12.2018.
 */
class TestRunner: AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    override fun newApplication(cl: ClassLoader, className: String, context: Context)
            : Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }

}