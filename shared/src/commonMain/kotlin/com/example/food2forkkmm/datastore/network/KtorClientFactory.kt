package com.example.food2forkkmm.datastore.network

import io.ktor.client.*

expect class KtorClientFactory(){
    fun build(): HttpClient
}