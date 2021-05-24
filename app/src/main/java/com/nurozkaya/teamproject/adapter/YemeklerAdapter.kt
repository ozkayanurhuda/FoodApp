package com.nurozkaya.teamproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nurozkaya.teamproject.databinding.AnasayfaCardBinding
import com.nurozkaya.teamproject.entity.Yemekler
import com.nurozkaya.teamproject.retrofit.ApiUtils
import com.nurozkaya.teamproject.viewmodel.AnasayfaFragmentViewModel
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext: Context, var yemeklerListesi:List<Yemekler>, var viewModel: AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>(){

        inner class CardTasarimTutucu(anasayfaCardBinding: AnasayfaCardBinding)
            : RecyclerView.ViewHolder(anasayfaCardBinding.root){

                var anasayfaCard: AnasayfaCardBinding

                init {
                    this.anasayfaCard = anasayfaCardBinding
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = AnasayfaCardBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val url = ApiUtils.BASE_URL + yemek.yemek_resim_adi
        holder.anasayfaCard.yemekNesne = yemek

        Picasso.get().load(url).into(holder.anasayfaCard.imageViewAnasayfa)


    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }
}