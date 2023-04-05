package com.example.thwnotizetb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thwnotizetb.data.TresorRepository
import kotlinx.coroutines.launch

class TresorViewModel(private val tresorRepository: TresorRepository) : ViewModel() {

        private val _tresorList = MutableLiveData<List<Tresor>>()
        val tresorList: LiveData<List<Tresor>> = _tresorList

        fun loadTresorList() {
            viewModelScope.launch {
                _tresorList.value = tresorRepository.getTresorList()
            }
        }

        fun addTresor(tresor: Tresor) {
            viewModelScope.launch {
                tresorRepository.addTresor(tresor)
                loadTresorList()
            }
        }

        fun removeTresor(tresor: Tresor) {
            viewModelScope.launch {
                tresorRepository.removeTresor(tresor)
                loadTresorList()
            }
        }
    }



