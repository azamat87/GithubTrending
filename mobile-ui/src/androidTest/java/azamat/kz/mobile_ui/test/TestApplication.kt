package azamat.kz.mobile_ui.test

import android.app.Activity
import android.app.Application
import android.content.pm.InstrumentationInfo
import azamat.kz.mobile_ui.injection.TestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import android.support.test.InstrumentationRegistry
import javax.inject.Inject

/**
 * Created by Asus on 15.12.2018.
 */
class TestApplication : Application(), HasActivityInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Activity>
    private lateinit var appComponent: TestApplicationComponent

    companion object {
        fun appComponent(): TestApplicationComponent{
            return (InstrumentationRegistry.getTargetContext().applicationContext as TestApplication).appComponent
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerTestApplicationComponent.builder().application(this).build
        appComponent.inject(this)

    }
}