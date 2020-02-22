package azamat.kz.mobile_ui.injection

import azamat.kz.data.repository.ProjectsRemote
import azamat.kz.remote.service.GithubTrendingService
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 15.12.2018.
 */
@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun provideGithubTrendingService(): GithubTrendingService {
        return mock()
    }

    @Provides
    @JvmStatic
    fun provideProjectsRemote(): ProjectsRemote {
        return mock()
    }

}