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
import com.example.thwnotizetb.databinding.DeleteNoteFragmentBinding


class DeleteNoteFragment : Fragment() {

    private val viewModel: NoteViewModel by activityViewModels()

    private lateinit var _binding: DeleteNoteFragmentBinding

    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DeleteNoteFragmentBinding.inflate(inflater)
        val index = requireArguments().getInt("index")
        val note = viewModel.notes.value?.get(index)

        binding.todelTv.setText(note?.text)

        val view = binding.root

        val button1 = view.findViewById<Button>(R.id.cancel_bt)
        //val button2 = view.findViewById<Button>(R.id.cDelete_bt)

        button1.setOnClickListener {
            findNavController().navigate(R.id.noteListFragment)
            Toast.makeText(context, "Abgebrochen", Toast.LENGTH_SHORT).show()
        }
        binding.cDeleteBt.setOnClickListener {
            val remTextView = binding.todelTv.text.toString()
            if (remTextView.isNotEmpty()) {
                viewModel.updateNoteAt(index, remTextView)
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Erfolgreich Gelöscht", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        val delNote = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        delNote.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}

