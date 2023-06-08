package com.example.dummyapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post:List<PostEntity>)

    @Query("Select * From PostEntityTable")
    suspend fun getData():List<PostEntity>

    @Query("SELECT * FROM PostEntityTable WHERE title = :str")
    suspend fun getDataByTitle(str:String):List<PostEntity>
}