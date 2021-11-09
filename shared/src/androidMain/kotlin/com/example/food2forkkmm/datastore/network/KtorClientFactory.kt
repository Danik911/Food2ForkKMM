package com.example.food2forkkmm.datastore.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

actual class KtorClientFactory{
    actual fun build(): HttpClient{
        return HttpClient(Android){
            install(JsonFeature){
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true // It will ignore extra fields from server
                    }
                )
            }
        }
    }
}