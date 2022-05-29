package lmd.pet.weathernew.data.repositories.image

import lmd.pet.weathernew.utils.enum.Image

interface ImageRepository {
    fun generateImageUrl(iconId: String, size: Image.Size, format: Image.Format): String
}