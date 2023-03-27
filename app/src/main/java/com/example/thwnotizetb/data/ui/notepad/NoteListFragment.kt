package com.example.thwnotizetb.data.ui.notepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    ): View? {
        return inflater.inflate(R.layout.note_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* .setOnClickListener {
                findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToAddNoteFragment())
            }
           // binding.nlBearbeitBt.setOnClickListener {
           //     findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment())
            //}
        }*/

    }
}











