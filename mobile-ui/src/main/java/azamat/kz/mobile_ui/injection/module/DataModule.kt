package azamat.kz.mobile_ui.injection.module

import azamat.kz.data.ProjectsDataRepository
import azamat.kz.domain.repository.ProjectsRepository
import dagger.Binds
import dagger.Module

/**
 * Created by Asus on 11.12.2018.
 */
@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository

}