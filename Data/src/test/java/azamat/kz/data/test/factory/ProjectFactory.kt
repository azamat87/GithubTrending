package azamat.kz.data.test.factory

import azamat.kz.data.model.ProjectEntity
import azamat.kz.domain.model.Project
import java.util.*

/**
 * Created by Asus on 09.11.2018.
 */
object ProjectFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.50
    }

    fun makeProjectEntity(): ProjectEntity {
        return ProjectEntity(randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomBoolean())
    }

    fun makeProject(): Project {
        return Project(randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomBoolean())
    }

    fun makeProjectList(count: Int): List<ProjectEntity> {
        val projects = mutableListOf<ProjectEntity>()
        repeat(count) {
            projects.add(makeProjectEntity())
        }
        return projects
    }

}