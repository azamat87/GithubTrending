package azamat.kz.mobile_ui.injection

import android.app.Application
import azamat.kz.cache.db.ProjectsDatabase
import azamat.kz.data.repository.ProjectsCache
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 15.12.2018.
 */
@Module
object TestCacheModule {

    @Provides
    @JvmStatic
    fun provideDataBase(application: Application): ProjectsDatabase{
        return ProjectsDatabase.getInstance(application)
    }

    @Provides
    @JvmStatic
    fun provideProjectsCache(): ProjectsCache {
        return mock()
    }

}