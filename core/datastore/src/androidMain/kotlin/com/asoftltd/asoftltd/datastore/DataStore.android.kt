package com.asoftltd.asoftltd.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import android.content.Context

fun dataStore(context: Context): DataStore<Preferences> =
    createDataStore(
        producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
    )