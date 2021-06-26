package com.example.otus_kmm

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val ioDispatcher: CoroutineContext
    get() = Dispatchers.IO
actual val uiDispatcher: CoroutineContext
    get() = Dispatchers.Main