package azamat.kz.cache.mapper

import azamat.kz.cache.model.CachedProject
import azamat.kz.data.model.ProjectEntity

/**
 * Created by Asus on 06.12.2018.
 */
class CacheProjectMapper : CacheMapper<CachedProject, ProjectEntity> {

    override fun mapFromCached(type: CachedProject): ProjectEntity {
        return ProjectEntity(type.id, type.name, type.fullName, type.starCount,
                type.dateCreated, type.ownerName, type.ownerAvatar,
                type.isBookmarked)
    }

    override fun mapToCached(type: ProjectEntity): CachedProject {
        return CachedProject(type.id, type.name, type.fullName, type.starCount,
                type.dateCreated, type.ownerName, type.ownerAvatar,
                type.isBookmarked)
    }

}