package com.nurozkaya.teamproject.repo

import androidx.lifecycle.MutableLiveData
import com.nurozkaya.teamproject.entity.Yemekler
import com.nurozkaya.teamproject.entity.YemeklerCevap
import com.nurozkaya.teamproject.retrofit.ApiUtils
import com.nurozkaya.teamproject.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerdaoRepos {

    private val yemeklerListesi:MutableLiveData<List<Yemekler>>
    private val ydaoi:YemeklerDaoInterface

    init{
        ydaoi=ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi=MutableLiveData()
    }

    fun yemekleriGetir():MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun tumYemekleriAl() {
        ydaoi.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(
                call: Call<YemeklerCevap>?,
                response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value=liste
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {

            }

        })
    }

}