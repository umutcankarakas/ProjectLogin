package com.projectlogin.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.projectlogin.Model.User;

import java.util.List;

@Dao
public interface UserDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from user_table ORDER BY user ASC")
    LiveData<List<User>> getAlphabetizedUsers();

    @Query("SELECT password from user_table WHERE mail =:mail")
    LiveData<String> getPassword(String mail);

    @Insert
    void insert(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();
}
