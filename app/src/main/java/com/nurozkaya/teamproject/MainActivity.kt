package com.nurozkaya.teamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nurozkaya.teamproject.entity.YemeklerCevap
import com.nurozkaya.teamproject.retrofit.ApiUtils
import com.nurozkaya.teamproject.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var ydaoi:YemeklerDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ydaoi=ApiUtils.getYemeklerDaoInterface()
        tumYemekleriGoster()
    }
    fun tumYemekleriGoster() {
        ydaoi.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(
                call: Call<YemeklerCevap>?,
                response: Response<YemeklerCevap>) {

                val yemeklerListesi=response.body().yemekler

                for(y in yemeklerListesi) {
                    Log.e("*******************","********************************")
                    Log.e("Yemek id", y.yemek_id.toString())
                    Log.e("Yemek Adı", y.yemek_adi)
                    Log.e("Yemek Resim Adı",y.yemek_resim_adi)
                    Log.e("Yemek Fiyatı",y.yemek_fiyat.toString())
                }
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {

            }

        })
    }
}