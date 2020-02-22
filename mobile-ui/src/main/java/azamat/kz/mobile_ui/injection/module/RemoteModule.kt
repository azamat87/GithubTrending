package azamat.kz.mobile_ui.injection.module

import azamat.kz.data.repository.ProjectsRemote
import azamat.kz.mobile_ui.BuildConfig
import azamat.kz.remote.ProjectsRemoteImpl
import azamat.kz.remote.service.GithubTrendingService
import azamat.kz.remote.service.GithubTrendingServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 11.12.2018.
 */
@Module
abstract class RemoteModule {

    companion object {
        @Provides
        @JvmStatic
        fun providesGithubService(): GithubTrendingService{
            return GithubTrendingServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}