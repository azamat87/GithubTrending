package azamat.kz.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import azamat.kz.cache.db.ProjectConstants.DELETE_PROJECTS
import azamat.kz.cache.db.ProjectConstants.QUERY_BOOKMARKED_PROJECTS
import azamat.kz.cache.db.ProjectConstants.QUERY_PROJECTS
import azamat.kz.cache.db.ProjectConstants.QUERY_UPDATE_BOOKMARK_STATUS
import azamat.kz.cache.model.CachedProject
import io.reactivex.Flowable

/**
 * Created by Asus on 05.12.2018.
 */
@Dao
abstract class CachedProjectDao {

    @Query(QUERY_PROJECTS)
    abstract fun getPojects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query(DELETE_PROJECTS)
    abstract fun deleteProjects()

    @Query(QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProject>>

    @Query(QUERY_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(isBookmarked: Boolean, projectId: String)

}