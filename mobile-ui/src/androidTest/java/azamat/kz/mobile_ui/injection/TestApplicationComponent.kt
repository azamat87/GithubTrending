package azamat.kz.mobile_ui.injection

import android.app.Application
import azamat.kz.domain.repository.ProjectsRepository
import azamat.kz.mobile_ui.GithubTrendingApplication
import azamat.kz.mobile_ui.injection.module.PresentationModule
import azamat.kz.mobile_ui.injection.module.UiModule
import azamat.kz.mobile_ui.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Asus on 10.12.2018.
 */

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,
        TestApplicationModule::class,
        TestCacheModule::class,
        TestDataModule::class,
        PresentationModule::class,
        UiModule::class,
        TestRemoteModule::
))
interface TestApplicationComponent {

    fun projectRepository(): ProjectsRepository

    @Component.Builder
    interface Buiilder {
        @BindsInstance
        fun appliction(application: Application): Buiilder

        fun build(): TestApplicationComponent
    }

    fun inject(app: TestApplication)

}