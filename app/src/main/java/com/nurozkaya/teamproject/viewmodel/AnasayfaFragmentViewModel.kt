package com.nurozkaya.teamproject.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurozkaya.teamproject.R
import com.nurozkaya.teamproject.entity.Yemekler
import com.nurozkaya.teamproject.repo.YemeklerdaoRepos


class AnasayfaFragmentViewModel : ViewModel() {

    private val ydaor = YemeklerdaoRepos()
    var yemeklerlistesi = MutableLiveData<List<Yemekler>>()

    init{
        yemekleriYukle()
        yemeklerlistesi =ydaor.yemekleriGetir()
    }

    fun yemekleriYukle(){
        ydaor.tumYemekleriAl()
    }


}