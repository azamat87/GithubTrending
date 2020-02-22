package azamat.kz.presentation.browse

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import azamat.kz.domain.interactor.bookmark.GetBookmarkedProjects
import azamat.kz.domain.model.Project
import azamat.kz.presentation.mapper.ProjectViewMapper
import azamat.kz.presentation.model.ProjectView
import azamat.kz.presentation.state.Resource
import azamat.kz.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by Asus on 09.12.2018.
 */
class BrowseBoorkmrkedProjectsViewModel @Inject constructor(
        private val getBookmarkedProjects: GetBookmarkedProjects,
        private val mapper: ProjectViewMapper) : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }

    fun getProjects(): LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBookmarkedProjects.execute(ProjectsSubscriber())
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

}