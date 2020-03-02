package com.olabode.wilson.dagger.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.olabode.wilson.dagger.R;
import com.olabode.wilson.dagger.models.User;
import com.olabode.wilson.dagger.ui.auth.AuthResource;
import com.olabode.wilson.dagger.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */
public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";
    @Inject
    ViewModelProviderFactory providerFactory;
    private ProfileViewModel viewModel;
    private TextView username, email, website;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "PROFILE FRAGMENT CREATED");

        email = view.findViewById(R.id.email);
        username = view.findViewById(R.id.username);
        website = view.findViewById(R.id.website);

        viewModel = ViewModelProviders.of(this, providerFactory).get(ProfileViewModel.class);
        subscribeObservers();
    }


    private void subscribeObservers() {
        viewModel.getAuthenticatedUser().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthenticatedUser().observe(getViewLifecycleOwner(), new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> userAuthResource) {

                if (userAuthResource != null) {
                    switch (userAuthResource.status) {
                        case AUTHENTICATED: {
                            setUserDetails(userAuthResource.data);
                            break;
                        }
                        case ERROR: {
                            setErrorDetails(userAuthResource.message);
                            break;

                        }
                    }
                }
            }

        });

    }


    private void setErrorDetails(String message) {
        email.setText(message);
        username.setText("error");
        website.setText("error");
    }

    private void setUserDetails(User data) {
        email.setText(data.getEmail());
        website.setText(data.getWebsite());
        username.setText(data.getUsername());
    }
}
