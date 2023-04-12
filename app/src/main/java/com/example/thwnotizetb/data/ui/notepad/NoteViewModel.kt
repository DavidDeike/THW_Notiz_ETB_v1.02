package com.example.thwnotizetb.data.ui.notepad


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thwnotizetb.data.model.notepad.Note


class NoteViewModel : ViewModel() {

    var currentNum: Int = 0

    private val _notes: MutableLiveData<MutableList<Note>> = MutableLiveData(mutableListOf())

    val notes: MutableLiveData<MutableList<Note>>
        get() = _notes

    fun addNote(note: Note) {
        val notesList = _notes.value.orEmpty().toMutableList()
        notesList.add(0, note)
        _notes.value = notesList
    }

    fun deleteNoteAt(index: Int) {
        val notesList = _notes.value.orEmpty().toMutableList()
        if (index in notesList.indices) {
            notesList.removeAt(index)
            _notes.value = notesList
        }
    }

    fun updateNoteAt(index: Int, newText: String) {
        val notesList = _notes.value.orEmpty().toMutableList()
        if (index in notesList.indices) {
            notesList[index].text = newText
            _notes.value = notesList
        }
    }

    fun deleteCurrentNote() {
        val notesList = _notes.value.orEmpty().toMutableList()
        if (currentNum in notesList.indices) {
            notesList.removeAt(currentNum)
            _notes.value = notesList
        }
    }
}

