package com.thenexprojects.hiltexampleapplication.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.thenexprojects.hiltexampleapplication.model.User

@Dao
interface UsersDao {

    @Query("SELECT *  FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Delete
    suspend fun deleteUser(user: User)

    @Delete
    suspend fun deleteUsers(users: List<User>)

    @Update
    suspend fun updateUser(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(user: List<User>)

}