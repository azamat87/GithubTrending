package azamat.kz.domain.repository

import azamat.kz.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by Asus on 05.11.2018.
 */
interface ProjectsRepository {

    fun getProjects(): Observable<List<Project>>

    fun bookmarkProject(projectId: String): Completable

    fun unbookmarkProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>
}