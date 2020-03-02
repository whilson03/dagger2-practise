package com.olabode.wilson.dagger.di.auth;

import androidx.lifecycle.ViewModel;

import com.olabode.wilson.dagger.di.ViewModelKey;
import com.olabode.wilson.dagger.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by OLABODE WILSON on 2020-02-19.
 */
@Module
public abstract class AuthViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);
}
