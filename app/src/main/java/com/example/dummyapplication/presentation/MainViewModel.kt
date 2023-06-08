package com.example.dummyapplication.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyapplication.data.local.PostEntity
import com.example.dummyapplication.domain.PostRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PostRepository): ViewModel() {


    private val posts = MutableLiveData<List<PostEntity>>()
    val post: LiveData<List<PostEntity>> get() = posts
    fun getQuotes()
    {
        viewModelScope.launch {

            posts.value = repository.getQuotes(Application())
        }
    }

   fun getQuoteByTitle(title:String)
    {
        viewModelScope.launch {
            posts.value = repository.getPostsByTitle(title)
        }

    }
}