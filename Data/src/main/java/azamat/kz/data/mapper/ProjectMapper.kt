package azamat.kz.data.mapper

import azamat.kz.data.model.ProjectEntity
import azamat.kz.domain.model.Project
import javax.inject.Inject

/**
 * Created by Asus on 08.11.2018.
 */
class ProjectMapper @Inject constructor() : EntityMapper<ProjectEntity, Project> {

    override fun mapFromEntity(entity: ProjectEntity): Project {
        return Project(entity.id, entity.name, entity.fullName,
                entity.starCount, entity.dateCreated,
                entity.ownerName, entity.ownerAvatar,
                entity.isBookmarked)
    }

    override fun mapToEntity(domain: Project): ProjectEntity {
        return ProjectEntity(domain.id, domain.name, domain.fullName,
                domain.starCount, domain.dateCreated,
                domain.ownerName, domain.ownerAvatar,
                domain.isBookmarked)
    }
}