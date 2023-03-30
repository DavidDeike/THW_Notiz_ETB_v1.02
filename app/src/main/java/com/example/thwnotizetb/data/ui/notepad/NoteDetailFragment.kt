package com.example.thwnotizetb.data.ui.notepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R



class NoteDetailFragment : Fragment() {


    private var _binding: NoteDetailFragment? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: NoteViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.note_detail_fragment, container,false)

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
            findNavController().navigate(R.id.noteListFragment)
        }
        return view
    }






}
