package com.nurozkaya.teamproject.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.nurozkaya.teamproject.MainActivity
import com.nurozkaya.teamproject.R
import com.nurozkaya.teamproject.databinding.FragmentYemekDetayBinding
import com.nurozkaya.teamproject.retrofit.ApiUtils
import com.nurozkaya.teamproject.viewmodel.YemekDetayFragmentViewModel
import com.squareup.picasso.Picasso


class YemekDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentYemekDetayBinding
    private lateinit var viewModel: YemekDetayFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false)
        tasarim.yemekDetayFragment = this

        val  bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemekNesne
        tasarim.yemekNesnesi = gelenYemek
        val url = ApiUtils.BASE_URL +"yemekler/resimler/" +gelenYemek.yemek_resim_adi
        val image = tasarim.imageViewDetay
        Picasso.get().load(url).into(image)


        tasarim.imageViewBack.setOnClickListener{
            val yeniIntent = Intent( activity, MainActivity::class.java)
            startActivity(yeniIntent)
        }

        return tasarim.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Fragment içinde viewModel tanımlaması
        val tempViewModel: YemekDetayFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }


}