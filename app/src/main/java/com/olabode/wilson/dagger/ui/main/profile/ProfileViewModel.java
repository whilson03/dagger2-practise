package com.olabode.wilson.dagger.ui.main.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.olabode.wilson.dagger.SessionManager;
import com.olabode.wilson.dagger.models.User;
import com.olabode.wilson.dagger.ui.auth.AuthResource;

import javax.inject.Inject;

/**
 * Created by OLABODE WILSON on 2020-02-21.
 */
public class ProfileViewModel extends ViewModel {


    private final SessionManager sessionManager;

    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }


    public LiveData<AuthResource<User>> getAuthenticatedUser() {
        return sessionManager.getAuthUser();
    }
}
