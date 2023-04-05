package com.example.thwnotizetb.data.ui.notepad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.thwnotizetb.R
import com.example.thwnotizetb.data.model.notepad.Note


class NoteViewModel : ViewModel() {

    var currentNum : Int = 0

    private val _notes: MutableLiveData<MutableList<Note>> = MutableLiveData(mutableListOf<Note>())

    val notes: LiveData<MutableList<Note>>
    get() = _notes


    fun addNote(note: Note) {
       //val addNewNote = note("Text")
        _notes.value?.add(0 , note)
        _notes.value = notes.value
    }

    fun delNote(index: Int){
        _notes.value?.removeAt(index)
        _notes.value = notes.value
    }


}
