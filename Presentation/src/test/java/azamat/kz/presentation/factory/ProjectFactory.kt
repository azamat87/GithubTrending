package azamat.kz.presentation.factory

import azamat.kz.domain.model.Project
import azamat.kz.presentation.model.ProjectView

/**
 * Created by Asus on 09.12.2018.
 */
object ProjectFactory {

    fun makeProjectView(): ProjectView {
        return ProjectView(DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomBoolean())
    }

    fun makeProject(): Project {
        return Project(DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomUuid(),
                DataFactory.randomUuid(),DataFactory.randomBoolean())
    }

    fun makeProjectViewList(count: Int): List<ProjectView> {
        val projects = mutableListOf<ProjectView>()
        repeat(count) {
            projects.add(makeProjectView())
        }
        return projects
    }

    fun makeProjectList(count: Int): List<Project> {
        val projects = mutableListOf<Project>()
        repeat(count) {
            projects.add(makeProject())
        }
        return projects
    }

}