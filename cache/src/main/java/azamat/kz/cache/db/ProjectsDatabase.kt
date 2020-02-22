package azamat.kz.cache.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import azamat.kz.cache.dao.CachedProjectDao
import azamat.kz.cache.dao.ConfigDao
import azamat.kz.cache.model.CachedProject
import azamat.kz.cache.model.Config
import javax.inject.Inject

/**
 * Created by Asus on 04.12.2018.
 */
@Database(entities = arrayOf(CachedProject::class, Config::class), version = 1)
abstract class ProjectsDatabase @Inject constructor() : RoomDatabase(){

    abstract fun cacheProjectsDao(): CachedProjectDao

    abstract fun configDao(): ConfigDao

    companion object {
        private var INSTANCE: ProjectsDatabase? = null
        private val lock = Any()
        fun getInstance(context: Context): ProjectsDatabase{
            if (INSTANCE == null) {
                synchronized(lock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                ProjectsDatabase::class.java, "projects.db")
                                .build()
                    }
                    return INSTANCE as ProjectsDatabase
                }
            }
            return INSTANCE as ProjectsDatabase
        }
    }

}