package chepsi.anime.app.datasource.remote.utils


suspend fun <T : Any> safeApiCall(
    apiCall: suspend () -> T
): T = try {
    apiCall.invoke()
} catch (throwable: Throwable) {
    throw NetworkApiException(throwable.message.toString())
}

class NetworkApiException(message: String) : Exception(message)
