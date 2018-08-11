package com.projectlogin.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.projectlogin.Data.UserRepository;
import com.projectlogin.Model.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;
    // Using LiveData and caching what getAlphabetizedUsers returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.

    public UserViewModel (Application application) {
        super(application);
        mRepository = new UserRepository(application);

    }
    public LiveData<String> getPassword(String mail) {return mRepository.getPassword(mail);}
    public void insert(User user) { mRepository.insert(user); }
}