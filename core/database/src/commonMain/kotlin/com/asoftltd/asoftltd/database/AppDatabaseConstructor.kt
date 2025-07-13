package com.asoftltd.asoftltd.database

import androidx.room.RoomDatabaseConstructor
import com.asoftltd.asoftltd.database.AppDatabase

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor: RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}