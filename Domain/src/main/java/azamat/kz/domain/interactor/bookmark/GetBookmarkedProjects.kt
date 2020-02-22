package azamat.kz.domain.interactor.bookmark

import azamat.kz.domain.executer.PostExecutionThread
import azamat.kz.domain.interactor.ObservableUseCase
import azamat.kz.domain.model.Project
import azamat.kz.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Asus on 06.11.2018.
 */
class GetBookmarkedProjects @Inject constructor(
        private val repository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread){

    override fun buildsUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return repository.getBookmarkedProjects()
    }

}