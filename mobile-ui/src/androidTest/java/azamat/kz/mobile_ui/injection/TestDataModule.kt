package azamat.kz.mobile_ui.injection

import azamat.kz.domain.repository.ProjectsRepository
import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides

/**
 * Created by Asus on 15.12.2018.
 */
@Module
object TestDataModule {

    @Provides
    @JvmStatic
    fun provideDataRepository(): ProjectsRepository {
        return mock()
    }

}