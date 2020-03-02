package com.olabode.wilson.dagger.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.olabode.wilson.dagger.SessionManager;
import com.olabode.wilson.dagger.models.User;
import com.olabode.wilson.dagger.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by OLABODE WILSON on 2020-02-19.
 */
public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;

    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;

    }


    public void authenticateWithId(int userId) {
        Log.d(TAG, "authenticateWithId : Attempting to authenticate");
        sessionManager.authenticateWithUserId(quetyUserId(userId));
    }

    private LiveData<AuthResource<User>> quetyUserId(int userId) {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId).
                        onErrorReturn(new Function<Throwable, User>() {
                            @Override
                            public User apply(Throwable throwable) throws Exception {
                                User errorUser = new User();
                                errorUser.setId(-1);
                                return errorUser;
                            }
                        }).map(new Function<User, AuthResource<User>>() {
                    @Override
                    public AuthResource<User> apply(User user) throws Exception {
                        if (user.getId() == -1) {
                            return AuthResource.error("could not authenticate", null);
                        }
                        return AuthResource.authenticated(user);
                    }
                }).subscribeOn(Schedulers.io())

        );
    }


    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }
}
