package com.example.thwnotizetb.data.ui.notepad

import NoteAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note


class NoteAddFragment : Fragment() {


    private var _binding: NoteAddFragment? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: NoteViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.note_add_fragment, container,false)



        val button1b = view.findViewById<Button>(R.id.editNoteButton)
        val button2b = view.findViewById<Button>(R.id.deleteNoteButton)
        val button3b = view.findViewById<Button>(R.id.editNoteButton2)

        button1b.setOnClickListener {
            findNavController().navigate(R.id.noteListFragment)
        }
        button2b.setOnClickListener {
            findNavController().navigate(R.id.deleteNoteFragment)
        }
        button3b.setOnClickListener {
            findNavController().navigate(R.id.noteListFragment) //TODO Viemodel addnote ausführen
        }

        return view
    }





}
