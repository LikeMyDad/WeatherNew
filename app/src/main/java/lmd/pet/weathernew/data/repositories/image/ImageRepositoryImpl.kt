package lmd.pet.weathernew.data.repositories.image

import android.util.Log
import lmd.pet.weathernew.BuildConfig
import lmd.pet.weathernew.utils.enum.Image

class ImageRepositoryImpl : ImageRepository {
    override fun generateImageUrl(iconId: String, size: Image.Size, format: Image.Format): String {
        val url = BuildConfig.weatherIconUrl + iconId + size.type + format.type
        Log.d("ImageUrl", url)
        return url
    }
}