package azamat.kz.domain.interactor.browse

import azamat.kz.domain.executer.PostExecutionThread
import azamat.kz.domain.interactor.ObservableUseCase
import azamat.kz.domain.model.Project
import azamat.kz.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Asus on 06.11.2018.
 */
class GetProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    public override fun buildsUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getProjects()
    }

}