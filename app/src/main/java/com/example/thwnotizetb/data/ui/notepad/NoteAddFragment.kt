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
import com.example.thwnotizetb.databinding.NoteAddFragmentBinding


class NoteAddFragment : Fragment() {

    private val viewModel: NoteViewModel by activityViewModels()

    private lateinit var binding: NoteAddFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NoteAddFragmentBinding.inflate(inflater, container, false)

        val index = requireArguments().getInt("index")
        val note = viewModel.notes.value?.get(index)

        binding.addNoteTv.setText(note?.text)

        binding.editNoteButton2.setOnClickListener {
            val newText = binding.addNoteTv.text.toString()
            if (newText.isNotEmpty()) {
                viewModel.updateNoteAt(index, newText)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Erfolgreich Gespeichert", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        val addNote = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        addNote.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}

