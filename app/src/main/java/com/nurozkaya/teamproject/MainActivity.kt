package com.nurozkaya.teamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.util.Log
import android.view.Window
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nurozkaya.teamproject.entity.YemeklerCevap
import com.nurozkaya.teamproject.retrofit.ApiUtils
import com.nurozkaya.teamproject.retrofit.YemeklerDaoInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var ydaoi:YemeklerDaoInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)

        ydaoi=ApiUtils.getYemeklerDaoInterface()
        tumYemekleriGoster()

    }
    fun tumYemekleriGoster() {
        ydaoi.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(
                call: Call<YemeklerCevap>?,
                response: Response<YemeklerCevap>) {}

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {}

        })
    }


}