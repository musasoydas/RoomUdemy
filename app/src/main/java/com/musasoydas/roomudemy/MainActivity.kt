package com.musasoydas.roomudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var vt: VeriTabani
    private lateinit var kdao: KisilerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Veri tabanına erişmemizi sağlayan kod,önceden veri tabnı yoksa içindeki kodalar sayesinde veritabanını kopyalayıp telefona aktaracak,
        //eğer var ise direk dao inteface e ulaşıp fonksiyonları oluşturacaktır
        vt = VeriTabani.veritabaniErisim(this)!!

//        bu da infecaceye erişmek için (yani fonskiyonlarımıza)
        kdao = vt.getKisilerDao()
        //        kisileriYukle()
//        kisiGuncelle()
//        kisiSil()
//        kisileriYukle()
//        kisilerRatgeleGetir()
//        kisileriAra()
        istenenKisiyiGetir()
    }

    fun kisileriYukle() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var gelenListe = kdao.tumKisiler()

            for (gelen in gelenListe) {
                println(gelen.kisi_id)
                println(gelen.kisi_ad)
                println(gelen.kisi_yas)
                println("****************************")
            }

        }
    }


    fun kisiEkle() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var yeniKisi = Kisiler(0, "Perihan", 48)
            kdao.kisiEkle(yeniKisi)
        }
    }

    fun kisiGuncelle() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var guncellenecekKisi = Kisiler(3, "Yeni Perihan", 50)
            kdao.kisiGuncelle(guncellenecekKisi)
        }
    }

    fun kisiSil() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var silinecekKisi = Kisiler(3, "Yeni Perihan", 50)
            kdao.kisiSil(silinecekKisi)
        }
    }

    fun kisilerRatgeleGetir() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var gelenListe = kdao.kisiRastgele()

            for (gelen in gelenListe) {
                println(gelen.kisi_id)
                println(gelen.kisi_ad)
                println(gelen.kisi_yas)
            }

        }
    }

    fun kisileriAra() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var gelenListe = kdao.arananKisi("s")
            for (gelen in gelenListe) {
                println(gelen.kisi_id)
                println(gelen.kisi_ad)
                println(gelen.kisi_yas)
                println("****************************")
            }


        }
    }

    fun istenenKisiyiGetir() {
        val jobs = CoroutineScope(Dispatchers.Main).launch {
            var gelenkisi = kdao.kisiGetir(1)
            println(gelenkisi.kisi_id)
            println(gelenkisi.kisi_ad)
            println(gelenkisi.kisi_yas)

        }
    }
}