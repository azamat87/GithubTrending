package azamat.kz.presentation.browse

import android.arch.core.executor.testing.InstantTaskExecutorRule
import azamat.kz.domain.interactor.bookmark.BookmarkProject
import azamat.kz.domain.interactor.bookmark.UnbookmarkProject
import azamat.kz.domain.interactor.browse.GetProjects
import azamat.kz.domain.model.Project
import azamat.kz.presentation.factory.DataFactory
import azamat.kz.presentation.factory.ProjectFactory
import azamat.kz.presentation.mapper.ProjectViewMapper
import azamat.kz.presentation.model.ProjectView
import azamat.kz.presentation.state.ResourceState
import com.nhaarman.mockitokotlin2.*
import io.reactivex.observers.DisposableObserver
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

/**
 * Created by Asus on 09.12.2018.
 */
@RunWith(JUnit4::class)
class BrowseProjectsViewModelTest {

    @get:Rule
    var instantTaskExecutorTask = InstantTaskExecutorRule()

    var getProject = mock<GetProjects>()
    var bookmarkProject = mock<BookmarkProject>()
    var unbookmarkProject = mock<UnbookmarkProject>()
    var mapper = mock<ProjectViewMapper>()
    var projectViewModel = BrowseProjectsViewModel(getProject,
            bookmarkProject, unbookmarkProject, mapper)

    @Captor
    val captor = argumentCaptor<DisposableObserver<List<Project>>>()

    @Test
    fun fetchProjectsExecutesUseCase() {
        projectViewModel.fetchProjects()

        verify(getProject, times(1)).execute(any(), eq(null))
    }

    @Test
    fun fetchProjectsReturnSuccess() {
        val projects = ProjectFactory.makeProjectList(2)
        val projectsViews = ProjectFactory.makeProjectViewList(2)
        stupProjectMapperMapToView(projectsViews[0], projects[0])
        stupProjectMapperMapToView(projectsViews[1], projects[1])

        projectViewModel.fetchProjects()

        verify(getProject).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(projects)

        assertEquals(ResourceState.SUCCESS, projectViewModel.getProjects().value?.status)
    }

    @Test
    fun fetchProjectsReturnData() {
        val projects = ProjectFactory.makeProjectList(2)
        val projectsViews = ProjectFactory.makeProjectViewList(2)
        stupProjectMapperMapToView(projectsViews[0], projects[0])
        stupProjectMapperMapToView(projectsViews[1], projects[1])

        projectViewModel.fetchProjects()

        verify(getProject).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(projects)

        assertEquals(projectsViews, projectViewModel.getProjects().value?.data)
    }

    @Test
    fun fetchProjectsReturnError() {
        projectViewModel.fetchProjects()

        verify(getProject).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())

        assertEquals(ResourceState.ERROR, projectViewModel.getProjects().value?.status)
    }

    @Test
    fun fetchProjectsReturnMessageError() {
        val errorMessage = DataFactory.randomUuid()
        projectViewModel.fetchProjects()

        verify(getProject).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(errorMessage))

        assertEquals(errorMessage, projectViewModel.getProjects().value?.message)
    }

    private fun stupProjectMapperMapToView(projectView: ProjectView,
                                           project: Project) {
        whenever(mapper.mapToView(project))
                .thenReturn(projectView)

    }

}