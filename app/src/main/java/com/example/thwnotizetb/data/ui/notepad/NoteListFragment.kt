package com.example.thwnotizetb.data.ui.notepad

import NoteAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.databinding.NoteListFragmentBinding

class NoteListFragment : Fragment() {

    var x : Int = 5

    private lateinit var _binding: NoteListFragmentBinding

    private val binding get() = _binding

    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = NoteListFragmentBinding.inflate(inflater)

        return _binding.root






    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nlHinzuBt.setOnClickListener {
            val newNote = Note("")
            viewModel.addNote(newNote)
            viewModel.currentNum = 0
            it.findNavController().navigate(R.id.action_noteListFragment_to_noteDetailFragment)
        }
    }
}



















