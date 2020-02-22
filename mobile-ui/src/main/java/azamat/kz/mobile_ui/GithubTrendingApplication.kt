package azamat.kz.mobile_ui

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Asus on 09.12.2018.
 */
class GithubTrendingApplication : Application(), HasActivityInjector{

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build
                .inject(this)


    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}