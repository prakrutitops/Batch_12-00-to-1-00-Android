package com.example.roomdb.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomdb.Model.User

@Dao
interface Daoclass
{
    @Insert
    fun insertdata(user: User)

    @Query("select * from users")
    fun getUsers(): MutableList<User>

    @Update
    fun updatedata(user: User)

    @Delete
    fun deletedata(user: User)

}