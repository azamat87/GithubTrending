package azamat.kz.mobile_ui.mapper

import azamat.kz.mobile_ui.model.Project
import azamat.kz.presentation.model.ProjectView
import javax.inject.Inject

/**
 * Created by Asus on 10.12.2018.
 */
class ProjectViewMapper @Inject constructor(): ViewMapper<ProjectView, Project>{

    override fun mapToView(presentation: ProjectView): Project {
        return Project(presentation.id, presentation.name, presentation.fullName,
                presentation.starCount, presentation.dateCreated,
                presentation.ownerName, presentation.ownerAvatar,
                presentation.isBookmarked)
    }
}