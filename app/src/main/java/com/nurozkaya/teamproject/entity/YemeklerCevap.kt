package com.nurozkaya.teamproject.entity
//2
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class YemeklerCevap(@SerializedName("yemekler")
                         @Expose
                         var yemekler:List<Yemekler>,
                         @SerializedName("success")
                         @Expose
                         var yemek_ad:Int) {
}