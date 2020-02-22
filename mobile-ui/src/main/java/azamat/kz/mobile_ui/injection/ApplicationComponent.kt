package azamat.kz.mobile_ui.injection

import android.app.Application
import azamat.kz.mobile_ui.GithubTrendingApplication
import azamat.kz.mobile_ui.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Asus on 10.12.2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,
        ApplicationModule::class,
        UiModule::class,
        PresentationModule::class,
        DataModule::class,
        CacheModule::class,
        RemoteModule::class
))
interface ApplicationComponent {

    @Component.Builder
    interface Buiilder {
        @BindsInstance
        fun appliction(application: Application): Buiilder

        fun build(): ApplicationComponent
    }

    fun inject(app: GithubTrendingApplication)

}