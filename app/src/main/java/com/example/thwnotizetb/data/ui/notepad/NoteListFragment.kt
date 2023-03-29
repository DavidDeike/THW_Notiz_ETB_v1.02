package com.example.thwnotizetb.data.ui.notepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R

class NoteListFragment : Fragment() {

    companion object {
        fun newInstance() = NoteListFragment()
    }

    private var _binding: NoteListFragment? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.note_list_fragment, container,false)

        val Button1 = view.findViewById<Button>(R.id.nlHinzu_bt)
        val Button2 = view.findViewById<Button>(R.id.nlBearbeit_bt)

           Button1.setOnClickListener {
               findNavController().navigate(R.id.noteDetailFragment)
            }
            Button2.setOnClickListener {
                findNavController().navigate(R.id.addNoteFragment)
            }

        return view
    }

}



















