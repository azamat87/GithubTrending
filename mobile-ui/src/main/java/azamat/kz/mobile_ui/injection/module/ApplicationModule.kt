package azamat.kz.mobile_ui.injection.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by Asus on 11.12.2018.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}