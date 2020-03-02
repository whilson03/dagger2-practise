package com.olabode.wilson.dagger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.olabode.wilson.dagger.models.User;
import com.olabode.wilson.dagger.ui.auth.AuthActivity;
import com.olabode.wilson.dagger.ui.auth.AuthResource;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";


    @Inject
    public
    SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        subscribeObserver();
    }


    private void subscribeObserver() {
        sessionManager.getAuthUser().observe(this, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {
                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case LOADING: {

                            break;
                        }
                        case AUTHENTICATED: {

                            break;
                        }
                        case NOT_AUTHENTICATED: {

                            navLoginScreen();
                            break;
                        }
                        case ERROR: {
                            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
            }

        });
    }


    private void navLoginScreen() {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
        finish();
    }


}
