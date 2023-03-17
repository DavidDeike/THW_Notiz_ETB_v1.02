package com.example.thwnotizetb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thwnotizetb.databinding.TresorItemBinding


class TresorFragment : Fragment() {

    private var _binding: TresorItemBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = TresorItemBinding.inflate(inflater, container, false)
        return binding.root
    }


}







