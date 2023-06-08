package com.example.dummyapplication.data

import com.example.dummyapplication.data.remote.PostList
import com.example.dummyapplication.data.remote.PostListItem
import retrofit2.Response
import retrofit2.http.GET

interface Api {
   @GET("posts")
   suspend fun getInfo():Response<PostList>

}