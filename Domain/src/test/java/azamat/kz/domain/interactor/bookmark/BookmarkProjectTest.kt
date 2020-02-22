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

class BookmarkProjectTest {

    private lateinit var bookmarkProject: BookmarkProject

    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        bookmarkProject = BookmarkProject(projectsRepository, postExecutionThread)
    }

    @Test
    fun bookmarkProjectCompletes() {
        stubGetProjects(Completable.complete())
        val testObserver = bookmarkProject.buildsUseCaseCompletable(
                BookmarkProject.Params.forProject(ProjectDataFactory.randomUuid())
        ).test()
        testObserver.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun bookmarkProjectThrowException() {
      bookmarkProject.buildsUseCaseCompletable().test()
    }

    private fun stubGetProjects(completable: Completable) {
        whenever(projectsRepository.bookmarkProject(any()))
                .thenReturn(completable)
    }

}