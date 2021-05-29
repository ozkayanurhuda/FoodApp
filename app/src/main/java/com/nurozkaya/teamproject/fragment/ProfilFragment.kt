package com.nurozkaya.teamproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nurozkaya.teamproject.R
import com.nurozkaya.teamproject.databinding.FragmentProfilBinding
import com.nurozkaya.teamproject.entity.User


class ProfilFragment : Fragment() {
    private lateinit var design:FragmentProfilBinding
    private lateinit var u1: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_profil, container, false)
        u1 = User(1, "Floki Leo", "+90 (555) 555-5577", "leo@floki.com","logo_user")

        design.profilFragment = this
        design.user = u1
        design.imageViewUserProfile.setImageResource(requireContext().resources.getIdentifier(u1.user_image_name, "drawable",requireContext().packageName))

        
        return design.root
    }

}