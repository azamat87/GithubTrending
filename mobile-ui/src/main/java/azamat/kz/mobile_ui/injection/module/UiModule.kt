package azamat.kz.mobile_ui.injection.module

import azamat.kz.domain.executer.PostExecutionThread
import azamat.kz.mobile_ui.browse.BrowseActivity
import azamat.kz.mobile_ui.UiThread
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Asus on 11.12.2018.
 */
@Module
abstract class UiModule{

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowesActivity(): BrowseActivity
}