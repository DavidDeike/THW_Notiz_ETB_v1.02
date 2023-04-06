package com.example.thwnotizetb.data.ui.notepad

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.databinding.DeleteNoteFragmentBinding



class DeleteNoteFragment : Fragment() {

    private val viewModel: NoteViewModel by activityViewModels()

    private lateinit var _binding: DeleteNoteFragment

    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DeleteNoteFragmentBinding.inflate(inflater)
        val view = binding.root

        val button1 = view.findViewById<Button>(R.id.cancel_bt)
        val button2 = view.findViewById<Button>(R.id.cDelete_bt)

        button1.setOnClickListener {
            findNavController().navigate(R.id.noteListFragment)
            Toast.makeText(context, "Abgebrochen", Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            viewModel.delNote()
            findNavController().navigate(R.id.deleteNoteFragment)
            Toast.makeText(context, "Entgültigt gelöscht", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        val delNote = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        delNote.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}
