package azamat.kz.presentation.mapper

import azamat.kz.domain.model.Project
import azamat.kz.presentation.model.ProjectView
import javax.inject.Inject

/**
 * Created by Asus on 08.12.2018.
 */
class ProjectViewMapper @Inject constructor(): Mapper<ProjectView, Project> {

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(type.id, type.fullName, type.fullName,
                type.starCount, type.dateCreated, type.ownerName,
                type.ownerAvatar, type.isBookmarked)
    }
}