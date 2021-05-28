package com.nurozkaya.teamproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.nurozkaya.teamproject.R
import com.nurozkaya.teamproject.adapter.YemeklerAdapter
import com.nurozkaya.teamproject.databinding.FragmentAnasayfaBinding
import com.nurozkaya.teamproject.viewmodel.AnasayfaFragmentViewModel


class AnasayfaFragment : Fragment() {
    private lateinit var adapter: YemeklerAdapter
    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Yemekler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yemeklerlistesi.observe(viewLifecycleOwner, { yemeklerListesi ->
            adapter = YemeklerAdapter(requireContext(),yemeklerListesi,viewModel)
            tasarim.yemeklerAdapter = adapter
        })

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }


}