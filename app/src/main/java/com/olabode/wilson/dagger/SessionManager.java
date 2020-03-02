package com.olabode.wilson.dagger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.olabode.wilson.dagger.models.User;
import com.olabode.wilson.dagger.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */
@Singleton
public class SessionManager {
    private static final String TAG = "com.olabode.wilson.dagger.SessionManager";

    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();


    @Inject
    public SessionManager() {
    }


    public void authenticateWithUserId(final LiveData<AuthResource<User>> source) {
        if (cachedUser != null) {
            cachedUser.setValue(AuthResource.loading((User) null));
            cachedUser.addSource(source, new Observer<AuthResource<User>>() {
                @Override
                public void onChanged(AuthResource<User> userAuthResource) {
                    cachedUser.setValue(userAuthResource);
                    cachedUser.removeSource(source);
                }
            });
        }
    }


    public void logOut() {
        cachedUser.setValue(AuthResource.<User>logout());
    }


    public LiveData<AuthResource<User>> getAuthUser() {
        return cachedUser;
    }

}
