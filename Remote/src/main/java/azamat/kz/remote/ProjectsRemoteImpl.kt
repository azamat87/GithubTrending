package azamat.kz.remote

import azamat.kz.data.model.ProjectEntity
import azamat.kz.data.repository.ProjectsRemote
import azamat.kz.remote.mapper.ProjectsResponseModelMapper
import azamat.kz.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Asus on 16.11.2018.
 */
class ProjectsRemoteImpl @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsResponseModelMapper): ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
                .map {
                    it.items.map { mapper.mapFromModel(it) }
                }

    }
}