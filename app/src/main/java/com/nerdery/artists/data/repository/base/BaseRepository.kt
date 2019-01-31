package com.nerdery.artists.data.repository.base

import kotlinx.coroutines.Dispatchers

abstract class BaseRepository {
    var ioDispatcher = Dispatchers.IO
}