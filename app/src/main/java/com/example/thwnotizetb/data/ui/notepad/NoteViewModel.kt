package com.example.thwnotizetb.data.ui.notepad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thwnotizetb.data.model.notepad.Note


class NoteViewModel : ViewModel() {

    private val _newNote: MutableLiveData<MutableList<Note>> = MutableLiveData(mutableListOf<Note>())

    val newNote: LiveData<MutableList<Note>>
    get() = _newNote


    fun addNote(text:String) {
        val addNewNote = Note("Text")
        _newNote.value?.add(0, Note(""))
        _newNote.value = newNote.value
    }

/*
 // Eine Instanz des Repository wird in einer Variablen gespeichert
    private val repository = Repository()

    // Die Liste aus Kontakten wird in einer verschachtelten Variable gespeichert
    private val _contactList = MutableLiveData<List<Contact>>(repository.loadContacts())
    val contactList: LiveData<List<Contact>>
        get() = _contactList

    // Die Liste an ChatNachrichten wird in einer verschachtelten Variable gespeichert
    private val _chat = MutableLiveData<MutableList<Message>>(mutableListOf())
    val chat: LiveData<MutableList<Message>>
        get() = _chat

    /**
     * Diese Funktion initialisiert den Chat und setzt die Variablen dementsprechend
     */
    fun loadChat( Int) {
        val contact = contactList.value?.find { it.id == id }

        if (contact != null) {
            _chat.value = contact.chatHistory
        }
    }

    /**
     * Diese Funktion "schickt die Draft Message ab",
     * indem die Variablen dementsprechend gesetzt werden
     */
    fun sendMessage(text: String) {
        val newMessage = Message(text, false)
        _chat.value?.add(0, newMessage)
        _chat.value = chat.value

        viewModelScope.launch {
            delay(5000)
            generateAnswer()
        }
    }

    /**
     * BONUS
     */

    private fun generateAnswer() {
        val random = (1..5).random()

        val answer = when (random) {
            1 -> "okay. tell me more ;)"
            2 -> "leave me alone dude!!!"
            3 -> "nice to hear that!\nHow are you?"
            4 -> "haha"
            5 -> "I totally get it ;)"
            else -> ".."
        }

        val newMessage = Message(answer, true)
        _chat.value?.add(0, newMessage)

        _chat.value = chat.value

 */
}
