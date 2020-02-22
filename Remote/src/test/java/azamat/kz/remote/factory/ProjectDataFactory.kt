package azamat.kz.remote.test.factory

import azamat.kz.data.model.ProjectEntity
import azamat.kz.remote.model.OwnerModel
import azamat.kz.remote.model.ProjectModel
import azamat.kz.remote.model.ProjectsResponseModel

/**
 * Created by Asus on 16.11.2018.
 */
object ProjectDataFactory {

    fun makeOwner(): OwnerModel{
        return OwnerModel(DataFactory.randomUuid(), DataFactory.randomUuid())
    }

    fun makeProject(): ProjectModel{
        return ProjectModel(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomInt(), DataFactory.randomUuid(),
                makeOwner())
    }

    fun makeProjectEntity(): ProjectEntity{
        return ProjectEntity(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomBoolean())
    }


    fun makeProjectResponse(): ProjectsResponseModel{
        return ProjectsResponseModel(listOf(makeProject(), makeProject()))
    }

}