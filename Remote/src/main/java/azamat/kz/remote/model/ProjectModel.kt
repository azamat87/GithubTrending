package azamat.kz.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Asus on 16.11.2018.
 */
class ProjectModel (val id: String, val name: String,
                    @SerializedName("full_name") val fullName: String,
                    @SerializedName("startgazers_count") val startCount: Int,
                    @SerializedName("created_at") val dateCreated: String,
                    val owner: OwnerModel)