package com.example.dummyapplication.domain

import android.app.Application
import android.util.Log
import com.example.dummyapplication.data.Api
import com.example.dummyapplication.data.local.PostEntity
import com.example.dummyapplication.data.local.PostInfoDao


class PostRepository(
    private val dao: PostInfoDao,
    private val postApi: Api
) {

    suspend fun getQuotes(application: Application): List<PostEntity> {


        val post = dao.getData()
        if (post.isEmpty()) {
            val result = postApi.getInfo()
            if (result.body() != null) {
                dao.insert(result.body()!!.map { it.toPostInfoEntity() })
                return result.body()!!.map { it.toPostInfoEntity() }
            }

        }
        return post
    }


    suspend fun getPostsByTitle(title: String): List<PostEntity> {

        return dao.getDataByTitle(title)
    }
}