package com.musasoydas.roomudemy

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface KisilerDao {


    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler(): List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisi: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi: Kisiler)

    @Delete
    suspend fun kisiSil(kisi: Kisiler)


    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 1")
    suspend fun kisiRastgele(): List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_ad LIKE '%' || :arananKelime || '%' ")
    suspend fun arananKisi(arananKelime: String): List<Kisiler>


    @Query("SELECT * FROM kisiler WHERE kisi_id= :kisi_id")
    suspend fun kisiGetir(kisi_id: Int): Kisiler

}