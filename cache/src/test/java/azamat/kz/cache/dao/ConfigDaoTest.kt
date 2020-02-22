package azamat.kz.cache.dao

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import azamat.kz.cache.db.ProjectsDatabase
import azamat.kz.cache.test.factory.ConfigDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals

/**
 * Created by Asus on 08.12.2018.
 */
@RunWith(RobolectricTestRunner::class)
class ConfigDaoTest {

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
    fun saveConfigurationSaveData() {
        val config = ConfigDataFactory.makeCachedConfig()
        database.configDao().insertConfig(config)

        val cacheConfig = database.configDao().getConfig()
        assertEquals(config.lastCacheTime, cacheConfig.lastCacheTime)
    }

}