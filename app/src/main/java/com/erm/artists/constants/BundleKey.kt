package com.erm.artists.constants

enum class BundleKey {
    ARTIST_NAME;

    override fun toString(): String {
        return name
    }
}