package azamat.kz.remote

import azamat.kz.data.model.ProjectEntity
import azamat.kz.remote.mapper.ProjectsResponseModelMapper
import azamat.kz.remote.model.ProjectModel
import azamat.kz.remote.model.ProjectsResponseModel
import azamat.kz.remote.service.GithubTrendingService
import azamat.kz.remote.test.factory.ProjectDataFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Asus on 25.11.2018.
 */
@RunWith(JUnit4::class)
class ProjectRemoteImplTest {

    private val mapper = mock<ProjectsResponseModelMapper>()
    private val service = mock<GithubTrendingService>()
    private val remote = ProjectsRemoteImpl(service, mapper)

    @Test
    fun getProjectsCompletes() {
        stubGitHubTrendingServiceSearchRepositories(Observable.just(ProjectDataFactory.makeProjectResponse()))
        stubGitHubTrendingServiceSearchRepositories(any(), ProjectDataFactory.makeProjectEntity())
        val testObserver = remote.getProjects().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsCallsServer() {
        stubGitHubTrendingServiceSearchRepositories(Observable.just(ProjectDataFactory.makeProjectResponse()))
        stubGitHubTrendingServiceSearchRepositories(any(), ProjectDataFactory.makeProjectEntity())
        remote.getProjects().test()
        verify(service).searchRepositories(any(), any(), any())
    }

    @Test
    fun getProjectsReturnsData() {
        val response = ProjectDataFactory.makeProjectResponse()
        stubGitHubTrendingServiceSearchRepositories(Observable.just(ProjectDataFactory.makeProjectResponse()))

        val entities = mutableListOf<ProjectEntity>()
        response.items.forEach {
            val entity = ProjectDataFactory.makeProjectEntity()
            entities.add(entity)
            stubGitHubTrendingServiceSearchRepositories(it, entity)
        }
        val testObserver = remote.getProjects().test()
        testObserver.assertValue(entities)
    }

    @Test
    fun getProjectsCallsServerWithCorrectParameters() {
        stubGitHubTrendingServiceSearchRepositories(Observable.just(ProjectDataFactory.makeProjectResponse()))
        stubGitHubTrendingServiceSearchRepositories(any(), ProjectDataFactory.makeProjectEntity())
        remote.getProjects().test()
        verify(service).searchRepositories("language:kotlin", "stars", "desc")
    }

    private fun stubGitHubTrendingServiceSearchRepositories(observable: Observable<ProjectsResponseModel>) {
        whenever(service.searchRepositories(any(), any(), any()))
                .thenReturn(observable)
    }

    private fun stubGitHubTrendingServiceSearchRepositories(model: ProjectModel,
                                                            entity: ProjectEntity) {
        whenever(mapper.mapFromModel(model))
                .thenReturn(entity)

    }

}