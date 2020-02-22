package azamat.kz.data.store

import azamat.kz.data.repository.ProjectsDataStore
import javax.inject.Inject

/**
 * Created by Asus on 08.11.2018.
 */
open class ProjectsDataStoreFactory @Inject constructor(
        private val projectsCacheDataStore: ProjectsCacheDataStore,
        private val projectsRemoteDataStore: ProjectsRemoteDataStore) {

    open fun getDataStore(projectCached: Boolean, cacheExpired: Boolean): ProjectsDataStore {
        return if (projectCached && !cacheExpired) {
            projectsCacheDataStore
        } else {
            projectsRemoteDataStore
        }
    }

    open fun getCacheDataStore(): ProjectsDataStore{
        return projectsCacheDataStore
    }
}