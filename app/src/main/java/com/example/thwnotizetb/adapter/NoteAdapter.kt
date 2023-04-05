

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


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {

    private var dataset : List<Note>  = listOf()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val text : TextView = view.findViewById(R.id.notetext_tv)
        val pen : ImageView = view.findViewById(R.id.pen_iv)
        val bin : ImageView = view.findViewById(R.id.del_iv)
        val deltext: TextView = view.findViewById(R.id.todel_tv)
    }

    fun submitList(noteList: List<Note>) {
        dataset = noteList
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val note : Note  = dataset[position]

        holder.text.text = note.text

        holder.pen.setOnClickListener{
            val navController = holder.itemView.findNavController()
            navController.navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteAddFragment())
        }
        holder.bin.setOnClickListener{
            val navController = holder.itemView.findNavController()
            navController.navigate(NoteListFragmentDirections.a)
        }

    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}