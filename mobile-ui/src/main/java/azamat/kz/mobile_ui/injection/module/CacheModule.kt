package azamat.kz.mobile_ui.injection.module

import android.app.Application
import azamat.kz.cache.ProjectsCacheImpl
import azamat.kz.cache.db.ProjectsDatabase
import azamat.kz.data.repository.ProjectsCache
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 11.12.2018.
 */
@Module
abstract class CacheModule {

    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): ProjectsDatabase{
            return ProjectsDatabase.getInstance(application)
        }

    }

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache

}