package azamat.kz.data.repository

import azamat.kz.data.model.ProjectEntity
import io.reactivex.Observable

/**
 * Created by Asus on 08.11.2018.
 */
interface ProjectsRemote {

    fun getProjects(): Observable<List<ProjectEntity>>

}