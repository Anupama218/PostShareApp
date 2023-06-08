package com.example.dummyapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummyapplication.R
import com.example.dummyapplication.data.Api
import com.example.dummyapplication.data.local.AppDatabase
import com.example.dummyapplication.data.remote.RetrofitHelper
import com.example.dummyapplication.databinding.FragmentPostTitleBinding
import com.example.dummyapplication.domain.PostRepository


class PostTitleFragment : Fragment() {

    private lateinit var myViewModel: MainViewModel
    private lateinit var binding: FragmentPostTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_title, container, false)
        fun item(title:String)
        {
            val bundle = Bundle()
            bundle.putString("key", title)
            findNavController().navigate(R.id.action_blankFragment_to_blankFragment2, bundle)
        }
        val api = RetrofitHelper.getInstance().create(Api::class.java)
        val dao = AppDatabase.getDatabase(requireActivity().applicationContext).postDao()
        val repository = PostRepository(dao, api)
        myViewModel = ViewModelProvider(ViewModelStore(),ViewModelFactory(repository))[MainViewModel::class.java]
        myViewModel.getQuotes()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        myViewModel.post.observe(viewLifecycleOwner){
            val adapter = it?.let { Adapter(it) { title->item(title) } }
            binding.recyclerView.adapter = adapter

        }
        return binding.root
    }






}