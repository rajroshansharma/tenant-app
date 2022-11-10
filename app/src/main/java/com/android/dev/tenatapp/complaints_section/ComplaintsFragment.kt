package com.android.dev.tenatapp.complaints_section

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.android.dev.tenatapp.R
import com.android.dev.tenatapp.databinding.FragmentComplaintsBinding


class ComplaintsFragment : Fragment() {
     lateinit var binding:FragmentComplaintsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_complaints, container, false)
        binding = FragmentComplaintsBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Complaints Section"

        binding.securityMCardView.setOnClickListener {
            findNavController().navigate(R.id.action_complaintsFragment_to_securitySectionFragment)
        }

        binding.foodMCardView.setOnClickListener {
            findNavController().navigate(R.id.action_complaintsFragment_to_foodSectionFragment)
        }

        binding.bedMCardView.setOnClickListener {
            findNavController().navigate(R.id.action_complaintsFragment_to_bedroomSectionFragment)
        }
        binding.facMCardView.setOnClickListener {
            findNavController().navigate(R.id.action_complaintsFragment_to_facilitiesSectionFragment)
        }

    }




}