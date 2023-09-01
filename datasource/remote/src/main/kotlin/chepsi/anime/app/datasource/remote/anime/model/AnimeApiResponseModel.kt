package chepsi.anime.app.datasource.remote.anime.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeApiResponseModel(
    @SerialName("data")
    val `data`: List<Data>? = emptyList(),
    @SerialName("pagination")
    val pagination: Pagination? = null
) {
    @Serializable
    data class Data(
        @SerialName("aired")
        val aired: Aired? = null,
        @SerialName("airing")
        val airing: Boolean? = null,
        @SerialName("approved")
        val approved: Boolean? = null,
        @SerialName("background")
        val background: String? = null,
        @SerialName("broadcast")
        val broadcast: Broadcast? = null,
        @SerialName("demographics")
        val demographics: List<Demographic?>? = null,
        @SerialName("duration")
        val duration: String? = null,
        @SerialName("episodes")
        val episodes: Int? = null,
        @SerialName("favorites")
        val favorites: Int? = null,
        @SerialName("genres")
        val genres: List<Genre?>? = null,
        @SerialName("images")
        val images: Images? = null,
        @SerialName("licensors")
        val licensors: List<Licensor?>? = null,
        @SerialName("mal_id")
        val malId: Int? = null,
        @SerialName("members")
        val members: Int? = null,
        @SerialName("popularity")
        val popularity: Int? = null,
        @SerialName("producers")
        val producers: List<Producer?>? = null,
        @SerialName("rank")
        val rank: Int? = null,
        @SerialName("rating")
        val rating: String? = null,
        @SerialName("score")
        val score: Double? = null,
        @SerialName("scored_by")
        val scoredBy: Int? = null,
        @SerialName("season")
        val season: String? = null,
        @SerialName("source")
        val source: String? = null,
        @SerialName("status")
        val status: String? = null,
        @SerialName("studios")
        val studios: List<Studio?>? = null,
        @SerialName("synopsis")
        val synopsis: String? = null,
        @SerialName("themes")
        val themes: List<Theme?>? = null,
        @SerialName("title")
        val title: String? = null,
        @SerialName("title_english")
        val titleEnglish: String? = null,
        @SerialName("title_japanese")
        val titleJapanese: String? = null,
        @SerialName("title_synonyms")
        val titleSynonyms: List<String?>? = null,
        @SerialName("titles")
        val titles: List<Title?>? = null,
        @SerialName("trailer")
        val trailer: Trailer? = null,
        @SerialName("type")
        val type: String? = null,
        @SerialName("url")
        val url: String? = null,
        @SerialName("year")
        val year: Int? = null
    ) {
        @Serializable
        data class Aired(
            @SerialName("from")
            val from: String? = null,
            @SerialName("prop")
            val prop: Prop? = null,
            @SerialName("string")
            val string: String? = null,
            @SerialName("to")
            val to: String? = null
        ) {
            @Serializable
            data class Prop(
                @SerialName("from")
                val from: From? = null,
                @SerialName("to")
                val to: To? = null
            ) {
                @Serializable
                data class From(
                    @SerialName("day")
                    val day: Int? = null,
                    @SerialName("month")
                    val month: Int? = null,
                    @SerialName("year")
                    val year: Int? = null
                )

                @Serializable
                data class To(
                    @SerialName("day")
                    val day: Int? = null,
                    @SerialName("month")
                    val month: Int? = null,
                    @SerialName("year")
                    val year: Int? = null
                )
            }
        }

        @Serializable
        data class Broadcast(
            @SerialName("day")
            val day: String? = null,
            @SerialName("string")
            val string: String? = null,
            @SerialName("time")
            val time: String? = null,
            @SerialName("timezone")
            val timezone: String? = null
        )

        @Serializable
        data class Demographic(
            @SerialName("mal_id")
            val malId: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class Genre(
            @SerialName("mal_id")
            val malId: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class Images(
            @SerialName("jpg")
            val jpg: Jpg? = null,
            @SerialName("webp")
            val webp: Webp? = null
        ) {
            @Serializable
            data class Jpg(
                @SerialName("image_url")
                val imageUrl: String? = null,
                @SerialName("large_image_url")
                val largeImageUrl: String? = null,
                @SerialName("small_image_url")
                val smallImageUrl: String? = null
            )

            @Serializable
            data class Webp(
                @SerialName("image_url")
                val imageUrl: String? = null,
                @SerialName("large_image_url")
                val largeImageUrl: String? = null,
                @SerialName("small_image_url")
                val smallImageUrl: String? = null
            )
        }

        @Serializable
        data class Licensor(
            @SerialName("mal_id")
            val malId: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class Producer(
            @SerialName("mal_id")
            val malId: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class Studio(
            @SerialName("mal_id")
            val malId: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class Theme(
            @SerialName("mal_id")
            val malId: Int? = null,
            @SerialName("name")
            val name: String? = null,
            @SerialName("type")
            val type: String? = null,
            @SerialName("url")
            val url: String? = null
        )

        @Serializable
        data class Title(
            @SerialName("title")
            val title: String? = null,
            @SerialName("type")
            val type: String? = null
        )

        @Serializable
        data class Trailer(
            @SerialName("embed_url")
            val embedUrl: String? = null,
            @SerialName("images")
            val images: Images? = null,
            @SerialName("url")
            val url: String? = null,
            @SerialName("youtube_id")
            val youtubeId: String? = null
        ) {
            @Serializable
            data class Images(
                @SerialName("image_url")
                val imageUrl: String? = null,
                @SerialName("large_image_url")
                val largeImageUrl: String? = null,
                @SerialName("maximum_image_url")
                val maximumImageUrl: String? = null,
                @SerialName("medium_image_url")
                val mediumImageUrl: String? = null,
                @SerialName("small_image_url")
                val smallImageUrl: String? = null
            )
        }
    }

    @Serializable
    data class Pagination(
        @SerialName("current_page")
        val currentPage: Int? = null,
        @SerialName("has_next_page")
        val hasNextPage: Boolean? = null,
        @SerialName("items")
        val items: Items? = null,
        @SerialName("last_visible_page")
        val lastVisiblePage: Int? = null
    ) {
        @Serializable
        data class Items(
            @SerialName("count")
            val count: Int? = null,
            @SerialName("per_page")
            val perPage: Int? = null,
            @SerialName("total")
            val total: Int? = null
        )
    }
}
