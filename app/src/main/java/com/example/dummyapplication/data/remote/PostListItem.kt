package com.example.dummyapplication.data.remote

import com.example.dummyapplication.data.local.PostEntity

data class PostListItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
{
    fun toPostInfoEntity(): PostEntity {
        return PostEntity(
            body = body,
            id=id,
            title=title,

        )
    }
}