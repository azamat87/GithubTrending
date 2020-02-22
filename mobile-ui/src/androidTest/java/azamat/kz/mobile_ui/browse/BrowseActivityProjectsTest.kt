package azamat.kz.mobile_ui.browse

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import azamat.kz.data.test.factory.ProjectFactory
import azamat.kz.domain.model.Project
import azamat.kz.mobile_ui.R
import azamat.kz.mobile_ui.test.TestApplication
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Asus on 15.12.2018.
 */
@RunWith(AndroidJUnit4::class)
class BrowseActivityProjectsTest {

    @get:Rule
    val activity = ActivityTestRule<BrowseActivity>(BrowseActivity::class.java, false, false)

    @Test
    fun activityLaunches() {
        stubProjectsRepositoryGetProjects(Observable.just(listOf(ProjectFactory.makeProject())))
    }

    @Test
    fun projectsDisplay() {
        val projects = listOf(ProjectFactory.makeProject(),ProjectFactory.makeProject(),ProjectFactory.makeProject())
        stubProjectsRepositoryGetProjects(Observable.just(projects))
        activity.launchActivity(null)
        
        projects.forEachIndexed { index, project ->
            onView(ViewMatchers.withId(R.id.recycler_projects))
                    .perform(RecyclerViewActions.scrollToPosition<BrowseAdapter.ViewHolder>(index))

            onView(ViewMatchers.withId(R.id.recycler_projects))
                    .check(matches(ViewMatchers.hasDescendant(ViewMatchers.withText(project.fullName))))
        }

    }

    private fun stubProjectsRepositoryGetProjects(observable: Observable<List<Project>>){
        whenever(TestApplication.appComponent().projectRepository().getProjects())
                .thenReturn(observable)
    }

}