package azamat.kz.remote.mapper

import azamat.kz.data.model.ProjectEntity
import azamat.kz.remote.model.ProjectModel

/**
 * Created by Asus on 16.11.2018.
 */
class ProjectsResponseModelMapper: ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(model.id, model.name, model.fullName, model.startCount.toString(),
                model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar, false)
    }
}