package com.rickandmorty.rickandmortyapp.data.network.api

import com.rickandmorty.rickandmortyapp.data.network.model.CharacterItemNetwork
import com.rickandmorty.rickandmortyapp.data.network.model.CharacterNetworkResponse
import com.squareup.moshi.Moshi
import java.net.HttpURLConnection
import java.net.URL


class RickAndMortyApiNetwork(
    private val apiUrl: String,
    private val moshi: Moshi,
) : RickAndMortyApi {
    override fun getCharacter(): List<CharacterItemNetwork> {
        val url = URL(apiUrl)
        val con = url.openConnection() as HttpURLConnection
        val json = con.inputStream.bufferedReader().use { it.readText() }

        val jsonAdapter = moshi.adapter(CharacterNetworkResponse::class.java)
        val response = jsonAdapter.fromJson(json) as CharacterNetworkResponse

        return response.results
    }
}
