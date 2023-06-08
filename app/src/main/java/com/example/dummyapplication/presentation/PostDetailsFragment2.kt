package com.example.dummyapplication.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.dummyapplication.R
import com.example.dummyapplication.data.Api
import com.example.dummyapplication.data.local.AppDatabase
import com.example.dummyapplication.data.remote.RetrofitHelper
import com.example.dummyapplication.databinding.FragmentPostDetailsBinding
import com.example.dummyapplication.domain.PostRepository


class PostDetailsFragment2 : Fragment() {

    private lateinit var myViewModel: MainViewModel
    private lateinit var binding: FragmentPostDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_details, container, false)
        val postTitle = arguments?.getString("key")
        val api = RetrofitHelper.getInstance().create(Api::class.java)
        val dao = AppDatabase.getDatabase(requireActivity().applicationContext).postDao()
        val repository = PostRepository(dao, api)
        myViewModel = ViewModelProvider(
            ViewModelStore(),
            ViewModelFactory(repository)
        )[MainViewModel::class.java]
        if (postTitle != null) {
            myViewModel.getQuoteByTitle(postTitle)
        }
        myViewModel.post.observe(viewLifecycleOwner)
        {
            binding.title.text = it[0].title
            binding.content.text = it[0].body
        }
        return binding.root
    }





}