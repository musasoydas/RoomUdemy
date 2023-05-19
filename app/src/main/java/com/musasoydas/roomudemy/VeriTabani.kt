package com.musasoydas.roomudemy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Kisiler::class), version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun getKisilerDao(): KisilerDao

    companion object {
        var INSTANCE: VeriTabani? = null
        fun veritabaniErisim(context: Context): VeriTabani? {
            if (INSTANCE == null) {
                synchronized(VeriTabani::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        VeriTabani::class.java,
                        "rehber.sqlite"
                    )
                        .createFromAsset("rehber.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}