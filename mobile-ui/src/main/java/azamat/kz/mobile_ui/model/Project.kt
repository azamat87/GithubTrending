package azamat.kz.mobile_ui.model

/**
 * Created by Asus on 10.12.2018.
 */
class Project(val id: String,
              val name: String,
              val fullName: String,
              val starCount: String,
              val dateCreated: String,
              val ownerName: String,
              val ownerAvatar: String,
              var isBookmarked: Boolean) {
}