package azamat.kz.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Asus on 16.11.2018.
 */
class OwnerModel(@SerializedName("login") val ownerName: String,
                 @SerializedName("avatar_url") val ownerAvatar: String)