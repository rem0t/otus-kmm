package com.example.otus_kmm
import kotlin.coroutines.CoroutineContext

expect val ioDispatcher: CoroutineContext
expect val uiDispatcher: CoroutineContext