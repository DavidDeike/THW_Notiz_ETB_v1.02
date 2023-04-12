package com.example.thwnotizetb.data.ui.notepad

import NoteAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.databinding.NoteListFragmentBinding

class NoteListFragment : Fragment() {

    private val viewModel: NoteViewModel by activityViewModels()

    private lateinit var binding: NoteListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NoteListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NoteAdapter()
        binding.notesRecyclerView.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.nlHinzuBt.setOnClickListener {
            viewModel.currentNum = 0
            val note = Note("")
            viewModel.addNote(note)
            it.findNavController().navigate(R.id.action_noteListFragment_to_noteAddFragment)
        }
    }
}





















