package azamat.kz.cache.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import azamat.kz.cache.db.ProjectConstants

/**
 * Created by Asus on 03.12.2018.
 */
@Entity(tableName = ProjectConstants.TABLE_NAME)
data class CachedProject(@PrimaryKey
                         @ColumnInfo(name = ProjectConstants.COLUMN_PROJECT_ID)
                         val id: String,
                         val name: String,
                         val fullName: String,
                         val starCount: String,
                         val dateCreated: String,
                         val ownerName: String,
                         val ownerAvatar: String,
                         @ColumnInfo(name = ProjectConstants.COLUMN_IS_BOOKMRKED)
                         var isBookmarked: Boolean)