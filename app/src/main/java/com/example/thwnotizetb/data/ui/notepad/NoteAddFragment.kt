package com.example.thwnotizetb.data.ui.notepad

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.databinding.NoteAddFragmentBinding


class NoteAddFragment : Fragment() {

    private val viewModel: NoteViewModel by activityViewModels()

    private lateinit var _binding: NoteAddFragmentBinding

    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NoteAddFragmentBinding.inflate(inflater)
        val view = binding.root


        val button1b = binding.editNoteButton
        val button2b = binding.deleteNoteButton
        val button3b = binding.editNoteButton2

        button1b.setOnClickListener {
            findNavController().navigate(R.id.noteListFragment)
        }
        button2b.setOnClickListener {
            findNavController().navigate(R.id.deleteNoteFragment)
        }
        button3b.setOnClickListener {
            viewModel.addNote(Note(""))
            findNavController().navigate(R.id.noteListFragment)
            Toast.makeText(context, "Erfolgreich gespeichert", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        val addNote = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        addNote.hideSoftInputFromWindow(view?.windowToken, 0)
    }




}

