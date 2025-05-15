package com.zybooks.csgoroller;

import android.service.autofill.UserData;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import com.zybooks.csgoroller.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static final String dbName = "user";
    private static UserDatabase userDatabase;
    public static synchronized UserDatabase getUserDatabase(Context context)    {
        if(userDatabase == null)    {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDAO userDAO();

}
