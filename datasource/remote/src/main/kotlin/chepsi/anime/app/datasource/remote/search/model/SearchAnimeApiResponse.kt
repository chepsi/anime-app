package chepsi.anime.app.datasource.remote.search.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonTransformingSerializer

@Serializable
data class SearchAnimeApiResponse(
    @SerialName("error")
    val error: String? = null,
    @SerialName("frameCount")
    val frameCount: Int? = null,
    @SerialName("result")
    val result: List<Result?>? = null
) {
    @Serializable
    data class Result(
        @SerialName("anilist")
        val anilist: Int? = null,
        @Serializable(with = UserListSerializer::class)
        @SerialName("episode")
        val episode: String? = null,
        @SerialName("filename")
        val filename: String? = null,
        @SerialName("from")
        val from: Double? = null,
        @SerialName("image")
        val image: String? = null,
        @SerialName("similarity")
        val similarity: Double? = null,
        @SerialName("to")
        val to: Double? = null,
        @SerialName("video")
        val video: String? = null
    )
}
object UserListSerializer :
    JsonTransformingSerializer<String>(String.serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement =
        if (element is JsonArray) element.first() else element
}
