package com.example.thwnotizetb.data.ui.notepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.databinding.NoteListFragmentBinding

class NoteListFragment : Fragment() {

        private var _binding: NoteListFragmentBinding? = null

        private val binding get() = _binding!!


        private lateinit var viewModel: NoteViewModel

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.note_list_fragment, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.nlHinzuBt.setOnClickListener {
                findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToAddNoteFragment())
            }
           // binding.nlBearbeitBt.setOnClickListener {
           //     findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment())
            //}
        }

    }












