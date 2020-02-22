package azamat.kz.presentation.model

/**
 * Created by Asus on 08.12.2018.
 */
class ProjectView(val id: String,
                  val name: String,
                  val fullName: String,
                  val starCount: String,
                  val dateCreated: String,
                  val ownerName: String,
                  val ownerAvatar: String,
                  var isBookmarked: Boolean) {
}