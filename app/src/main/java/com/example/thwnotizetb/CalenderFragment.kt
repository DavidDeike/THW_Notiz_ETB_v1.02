package com.example.thwnotizetb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thwnotizetb.databinding.FragmentCalenderBinding


class CalenderFragment : Fragment() {

    private var _binding: FragmentCalenderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCalenderBinding.inflate(inflater, container, false)
        return binding.root
    }


//komentar


















}