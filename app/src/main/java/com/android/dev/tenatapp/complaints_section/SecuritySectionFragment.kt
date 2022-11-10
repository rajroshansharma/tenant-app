package com.android.dev.tenatapp.complaints_section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.android.dev.tenatapp.R
import com.android.dev.tenatapp.databinding.FragmentSecuritySectionBinding


class SecuritySectionFragment : Fragment() {
   lateinit var binding: FragmentSecuritySectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_security_section, container, false)
        binding = FragmentSecuritySectionBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Security complaint Section"
    }


}