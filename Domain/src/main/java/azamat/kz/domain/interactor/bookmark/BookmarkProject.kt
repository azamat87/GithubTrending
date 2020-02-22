package azamat.kz.domain.interactor.bookmark

import azamat.kz.domain.executer.PostExecutionThread
import azamat.kz.domain.interactor.CompletableUseCase
import azamat.kz.domain.repository.ProjectsRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Asus on 06.11.2018.
 */
class BookmarkProject @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : CompletableUseCase<BookmarkProject.Params>(postExecutionThread) {

    override fun buildsUseCaseCompletable(params: Params?): Completable {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.bookmarkProject(params.projectId)
    }

    data class Params constructor(val projectId: String) {
        companion object {
            fun forProject(projectId: String): Params{
                return Params(projectId)
            }
        }
    }
}