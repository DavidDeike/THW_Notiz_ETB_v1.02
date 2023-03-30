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



    private lateinit var _binding: NoteListFragment

    //private val binding get() = _binding

    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.note_list_fragment, container,false)

        val button1 = view.findViewById<Button>(R.id.nlHinzu_bt)
       //val button2 = view.findViewById<Button>(R.id.nlBearbeit_bt)

           button1.setOnClickListener {
               findNavController().navigate(R.id.noteDetailFragment)
            }
           /* button2.setOnClickListener {
                findNavController().navigate(R.id.noteDetailFragment)
            }*/

        return view
    }

}



















