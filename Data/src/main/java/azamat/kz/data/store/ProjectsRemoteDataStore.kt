package azamat.kz.data.store

import azamat.kz.data.model.ProjectEntity
import azamat.kz.data.repository.ProjectsDataStore
import azamat.kz.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Asus on 08.11.2018.
 */
class ProjectsRemoteDataStore @Inject constructor(private val projectsRemote: ProjectsRemote)
    : ProjectsDataStore{

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        throw UnsupportedOperationException("getBookmarkedProjects")
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("saveProjects")
    }

    override fun clearProjects(): Completable {
         throw UnsupportedOperationException("clearProjects")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
         throw UnsupportedOperationException("setProjectAsBookmarked")
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
         throw UnsupportedOperationException("setProjectAsNotBookmarked")
    }
}