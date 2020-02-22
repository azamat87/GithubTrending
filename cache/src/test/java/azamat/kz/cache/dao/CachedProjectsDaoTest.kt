package azamat.kz.cache.dao

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import azamat.kz.cache.db.ProjectsDatabase
import azamat.kz.cache.test.factory.ProjectDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

/**
 * Created by Asus on 08.12.2018.
 */
@RunWith(RobolectricTestRunner::class)
class CachedProjectsDaoTest {

    @Rule
    @JvmField
    var instantTaskExecuterRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
            RuntimeEnvironment.application.applicationContext,
            ProjectsDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun getProjectsReturnsData() {
        val projects = ProjectDataFactory.makeCachedProject()
        database.cacheProjectsDao().insertProjects(listOf(projects))

        val testObserver = database.cacheProjectsDao().getPojects().test()
        testObserver.assertValue(listOf(projects))
    }

    @Test
    fun deleteProjectsClearsData() {
        val projects = ProjectDataFactory.makeCachedProject()
        database.cacheProjectsDao().insertProjects(listOf(projects))
        database.cacheProjectsDao().deleteProjects()

        val testObserver = database.cacheProjectsDao().getPojects().test()
        testObserver.assertValue(emptyList())
    }

    @Test
    fun getBookmarkedProjectsReturnsData() {
        val project = ProjectDataFactory.makeCachedProject()
        val bookmarkedProject = ProjectDataFactory.makeBookmarkedCachedProject()
        database.cacheProjectsDao().insertProjects(listOf(project, bookmarkedProject))

        val testObserver = database.cacheProjectsDao().getBookmarkedProjects().test()
        testObserver.assertValue(listOf(bookmarkedProject))
    }

    @Test
    fun setProjectAsBookmarkedSavedData() {
        val project = ProjectDataFactory.makeCachedProject()
        database.cacheProjectsDao().insertProjects(listOf(project))
        database.cacheProjectsDao().setBookmarkStatus(true, project.id)
        project.isBookmarked = true

        val testObserver = database.cacheProjectsDao().getBookmarkedProjects().test()
        testObserver.assertValue(listOf(project))
    }

    @Test
    fun setProjectAsNotBookmarkedSavedData() {
        val project = ProjectDataFactory.makeBookmarkedCachedProject()
        database.cacheProjectsDao().insertProjects(listOf(project))
        database.cacheProjectsDao().setBookmarkStatus(false, project.id)
        project.isBookmarked = false

        val testObserver = database.cacheProjectsDao().getBookmarkedProjects().test()
        testObserver.assertValue(emptyList())
    }
}