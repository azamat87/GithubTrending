package azamat.kz.domain.test

import azamat.kz.domain.model.Project
import java.util.*

/**
 * Created by Asus on 07.11.2018.
 */
object ProjectDataFactory {

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.50
    }

    fun makeProject(): Project {
        return Project(randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomUuid(), randomUuid(), randomUuid(), randomBoolean())
    }

    fun makeProjectList(count: Int): List<Project> {
        val projects = mutableListOf<Project>()
        repeat(count) {
            projects.add(makeProject())
        }
        return projects
    }
}