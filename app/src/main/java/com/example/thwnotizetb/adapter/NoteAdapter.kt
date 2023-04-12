

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.data.ui.notepad.NoteListFragmentDirections
import com.example.thwnotizetb.databinding.NoteItemBinding


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {

    var dataset: List<Note> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    fun submitList(noteList: List<Note>) {
        dataset = noteList
    }


    inner class ItemViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.notetextTv.text = note.text
            binding.penIv.setOnClickListener {
                val index = adapterPosition
                val action = NoteListFragmentDirections.actionNoteListFragmentToNoteAddFragment(index)
                binding.root.findNavController().navigate(action)
            }
            binding.delIv.setOnClickListener {
                val index = adapterPosition
                val action = NoteListFragmentDirections.actionNoteListFragmentToDeleteNoteFragment(index)
                binding.root.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val note = dataset[position]
        holder.bind(note)
    }

    override fun getItemCount() = dataset.size
}

