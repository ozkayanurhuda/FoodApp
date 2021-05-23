package com.nurozkaya.teamproject.retrofit
//4
import com.nurozkaya.teamproject.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDaoInterface {
    @GET("yemekler/tum_yemekler.php")
    fun tumYemekler(): Call<YemeklerCevap>


}