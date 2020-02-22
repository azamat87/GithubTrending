package azamat.kz.presentation.browse

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import azamat.kz.domain.interactor.bookmark.BookmarkProject
import azamat.kz.domain.interactor.bookmark.UnbookmarkProject
import azamat.kz.domain.interactor.browse.GetProjects
import azamat.kz.domain.model.Project
import azamat.kz.presentation.mapper.ProjectViewMapper
import azamat.kz.presentation.model.ProjectView
import azamat.kz.presentation.state.Resource
import azamat.kz.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by Asus on 08.12.2018.
 */
class BrowseProjectsViewModel @Inject constructor(
        private val getProjects: GetProjects,
        private val bookmarkProject: BookmarkProject,
        private val unBookmarkProject: UnbookmarkProject,
        private val mapper: ProjectViewMapper): ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getProjects.dispose()
        super.onCleared()
    }

    fun getProjects(): LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getProjects.execute(ProjectsSubscriber())
    }

    fun bookmarkeProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return bookmarkProject.execute(BookmarkProjectsSubscriber(),
                BookmarkProject.Params.forProject(projectId))
    }

    fun unBookmarkeProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return unBookmarkProject.execute(BookmarkProjectsSubscriber(),
                UnbookmarkProject.Params.forProject(projectId))
    }

    inner class ProjectsSubscriber : DisposableObserver<List<Project>>() {

        override fun onError(e: Throwable?) {
            liveData.postValue(Resource(ResourceState.ERROR, null, null))
        }

        override fun onComplete() {}

        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS,
                    t.map { mapper.mapToView(it) },
                    null))
        }
    }

    inner class BookmarkProjectsSubscriber : DisposableCompletableObserver() {

        override fun onError(e: Throwable?) {
            liveData.postValue(Resource(ResourceState.ERROR, null, null))
        }

        override fun onComplete() {
            liveData.postValue(Resource(ResourceState.SUCCESS, liveData.value?.data, null))
        }

    }

}