package com.nurozkaya.teamproject.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nurozkaya.teamproject.databinding.AnasayfaCardBinding
import com.nurozkaya.teamproject.entity.Yemekler
import com.nurozkaya.teamproject.fragment.AnasayfaFragmentDirections
import com.nurozkaya.teamproject.retrofit.ApiUtils
import com.nurozkaya.teamproject.viewmodel.AnasayfaFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.anasayfa_card.view.*

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
        val url = ApiUtils.BASE_URL +"yemekler/resimler/" +yemek.yemek_resim_adi
        Log.e("url", url)
        holder.anasayfaCard.yemekNesne = yemek
        val image = holder.anasayfaCard.imageViewAnasayfa

        Picasso.get().load(url).into(image)


        holder.anasayfaCard.anasayfaCardView.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemek)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }
}