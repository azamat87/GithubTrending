package azamat.kz.cache.mapper

import azamat.kz.cache.model.CachedProject
import azamat.kz.cache.test.factory.ProjectDataFactory
import azamat.kz.data.model.ProjectEntity
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Asus on 07.12.2018.
 */
@RunWith(JUnit4::class)
class CachedProjectMapperTest {

    private val mapper = CacheProjectMapper()

    @Test
    fun mapFromCachedMapsData() {
        val model = ProjectDataFactory.makeCachedProject()
        val entity = mapper.mapFromCached(model)
        assertEqualData(model, entity)
    }

    @Test
    fun mapToCachedMapsData() {
        val entity = ProjectDataFactory.makeProjectEntity()
        val model = mapper.mapToCached(entity)
        assertEqualData(model, entity)
    }

    private fun assertEqualData(model: CachedProject, entity: ProjectEntity) {
        assertEquals(model.id, entity.id)
        assertEquals(model.fullName, entity.fullName)
        assertEquals(model.name, entity.name)
        assertEquals(model.dateCreated, entity.dateCreated)
        assertEquals(model.starCount, entity.starCount)
        assertEquals(model.ownerAvatar, entity.ownerAvatar)
        assertEquals(model.ownerName, entity.ownerName)
        assertEquals(model.isBookmarked, entity.isBookmarked)

    }

}