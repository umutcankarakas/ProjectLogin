package com.projectlogin.Model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user")
    private String mName;

    @ColumnInfo(name = "mail")
    private String mMail;

    @ColumnInfo(name = "password")
    private String mPassword;

    public User(@NonNull String mName, String mMail, String mPassword) {
        this.mName = mName;
        this.mMail = mMail;
        this.mPassword = mPassword;
    }

    public String getName(){
        return this.mName;
    }

    public String getMail() {
        return mMail;
    }

    public String getPassword() {
        return mPassword;
    }
}
