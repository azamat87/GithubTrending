package azamat.kz.cache.model

import android.arch.persistence.room.Entity
import azamat.kz.cache.db.ConfigConstants

/**
 * Created by Asus on 05.12.2018.
 */
@Entity(tableName = ConfigConstants.TABLE_NAME)
class Config(val lastCacheTime: Long) {
}