package azamat.kz.domain.interactor.bookmark

import azamat.kz.domain.executer.PostExecutionThread
import azamat.kz.domain.repository.ProjectsRepository
import azamat.kz.domain.test.ProjectDataFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by Asus on 07.11.2018.
 */
class UnbookmarkProjectTest {

    private lateinit var unbookmarkProject: UnbookmarkProject

    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        unbookmarkProject = UnbookmarkProject(projectsRepository, postExecutionThread)
    }

    @Test
    fun unbookmarkProjectCompletes() {
        stubGetProjects(Completable.complete())
        val testObserver = unbookmarkProject.buildsUseCaseCompletable(
                UnbookmarkProject.Params.forProject(ProjectDataFactory.randomUuid())
        ).test()
        testObserver.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun unbookmarkProjectThrowException() {
        unbookmarkProject.buildsUseCaseCompletable().test()
    }

    private fun stubGetProjects(completable: Completable) {
        whenever(projectsRepository.bookmarkProject(any()))
                .thenReturn(completable)
    }

}