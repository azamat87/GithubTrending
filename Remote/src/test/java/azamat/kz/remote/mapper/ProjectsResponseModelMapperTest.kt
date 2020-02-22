package azamat.kz.remote.test.mapper

import azamat.kz.remote.mapper.ProjectsResponseModelMapper
import azamat.kz.remote.test.factory.ProjectDataFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

/**
 * Created by Asus on 16.11.2018.
 */
@RunWith(JUnit4::class)
class ProjectsResponseModelMapperTest {

    private val mapper = ProjectsResponseModelMapper()

    @Test
    fun mapFromModelMapsData() {
        val model = ProjectDataFactory.makeProject()
        val entity = mapper.mapFromModel(model)
        assertEquals(model.id, entity.id)
    }

}