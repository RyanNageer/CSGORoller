package com.zybooks.csgoroller;

import androidx.room.*;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addUser(User user);

    @Query("SELECT * FROM users WHERE usr=(:usr) and pwd=(:pwd)")
    User login(String usr, String pwd);

    @Query("SELECT * FROM users WHERE id = :userId")
    User getUserById(long userId);

    @Update
    void updateUser(User user);

}
