package azamat.kz.data.repository

import azamat.kz.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by Asus on 08.11.2018.
 */
interface ProjectsDataStore {

    fun getProjects(): Observable<List<ProjectEntity>>

    fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

    fun saveProjects(projects: List<ProjectEntity>): Completable

    fun clearProjects(): Completable

    fun setProjectAsBookmarked(projectId: String): Completable

    fun setProjectAsNotBookmarked(projectId: String): Completable

}