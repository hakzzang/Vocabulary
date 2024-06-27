package com.damda.vocabulary.networks

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class ApiClient() {
    // HTTP 클라이언트 설정
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun loadByteArray(url: String): ByteArray = withContext(Dispatchers.Default) {
        val byteArray = client.get(url).body<ByteArray>()
        return@withContext byteArray
    }

}