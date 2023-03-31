

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note
import com.example.thwnotizetb.data.ui.notepad.AddNoteFragmentDirections
import com.example.thwnotizetb.data.ui.notepad.NoteDetailFragmentDirections


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ItemViewHolder>() {

    private var dataset : List<Note>  = listOf()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //val pen : ImageView = view.findViewById(R.id.pen_iv)
        //val thwLogo1 : ImageView = view.findViewById(R.id.blogo_iv)
        //val id : TextView = view.findViewById(R.id.noteId_tv)
        val text : TextView = view.findViewById(R.id.notetext_tv)
        val text1 : TextView = view.findViewById(R.id.addNote_tv)
        val fabButton : Button = view.findViewById(R.id.nlHinzu_bt)
        val clNewNoteL : ConstraintLayout = view.findViewById(R.id.clNewNoteL)
        val rvNote : RecyclerView = view.findViewById(R.id.notesRecyclerView)
    }


    fun submitList(noteList: List<Note>) {
        Log.d("NoteAdapter", "läuft")
        noteList.also { dataset = it }
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

        holder.text1.text = note.text
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}