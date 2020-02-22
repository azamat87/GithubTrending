package azamat.kz.cache

import azamat.kz.cache.db.ProjectsDatabase
import azamat.kz.cache.mapper.CacheProjectMapper
import azamat.kz.cache.model.Config
import azamat.kz.data.model.ProjectEntity
import azamat.kz.data.repository.ProjectsCache
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.toMaybe
import javax.inject.Inject

/**
 * Created by Asus on 06.12.2018.
 */
class ProjectsCacheImpl @Inject constructor(
        private val projectsDatabase: ProjectsDatabase,
        private val mapper: CacheProjectMapper
): ProjectsCache{

    override fun clearProjects(): Completable {
        return Completable.defer{
            projectsDatabase.cacheProjectsDao().deleteProjects()
            Completable.complete()
        }
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        return Completable.defer {
            projectsDatabase.cacheProjectsDao().insertProjects(
                    projects.map { mapper.mapToCached(it) })
            Completable.complete()
        }
    }

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsDatabase.cacheProjectsDao().getBookmarkedProjects()
                .toObservable()
                .map {
                    it.map { mapper.mapFromCached(it) }
                }
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        return projectsDatabase.cacheProjectsDao().getBookmarkedProjects()
                .toObservable()
                .map {
                    it.map { mapper.mapFromCached(it) }
                }
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        return Completable.defer {
            projectsDatabase.cacheProjectsDao().setBookmarkStatus(true, projectId)
            Completable.complete()
        }
    }

    override fun setProjectAsNotBookmarked(projectId: String): Completable {
        return Completable.defer {
            projectsDatabase.cacheProjectsDao().setBookmarkStatus(false, projectId)
            Completable.complete()
        }
    }

    override fun areProjectsCached(): Single<Boolean> {
        return projectsDatabase.cacheProjectsDao().getPojects().isEmpty
                .map { !it }
    }

    override fun setLastCacheTime(lastCahce: Long): Completable {
        return Completable.defer {
            projectsDatabase.configDao().insertConfig(Config(lastCacheTime = lastCahce))
            Completable.complete()
        }
    }

    override fun isProjectsCacheExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return projectsDatabase.configDao().getConfig()
                .toMaybe()
                .toSingle(Config(lastCacheTime = 0))
                .map {
                    currentTime - it.lastCacheTime > expirationTime
                }
    }


}