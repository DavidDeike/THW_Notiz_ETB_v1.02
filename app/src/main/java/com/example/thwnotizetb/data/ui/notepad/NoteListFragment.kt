package com.example.thwnotizetb.data.ui.notepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.databinding.NoteListFragmentBinding

class NoteListFragment : Fragment() {

    private val viewModel: NoteViewModel by activityViewModels()

    private lateinit var _binding: NoteListFragmentBinding

    private val binding get() = _binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       _binding = NoteListFragmentBinding.inflate(inflater)


        //return inflater.inflate(R.layout.note_list)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nlHinzuBt.setOnClickListener {
            val newNote = Note("")
            viewModel.addNote(newNote)
            viewModel.currentNum = 0
            it.findNavController().navigate(R.id.action_noteListFragment_to_noteAddFragment)
        }
    }
}





















