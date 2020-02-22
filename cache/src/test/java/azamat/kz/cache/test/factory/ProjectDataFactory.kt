package azamat.kz.cache.test.factory

import azamat.kz.cache.model.CachedProject
import azamat.kz.data.model.ProjectEntity

/**
 * Created by Asus on 07.12.2018.
 */
object ProjectDataFactory {

    fun makeCachedProject(): CachedProject {
        return CachedProject(DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),false)
    }

    fun makeProjectEntity(): ProjectEntity {
        return ProjectEntity(DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomBoolean())
    }

    fun makeBookmarkedCachedProject(): CachedProject {
        return CachedProject(DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),true)
    }

    fun makeBookmarkedProjectEntity(): ProjectEntity {
        return ProjectEntity(DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),true)
    }

}