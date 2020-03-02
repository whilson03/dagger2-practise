package com.olabode.wilson.dagger.di.main;

import androidx.lifecycle.ViewModel;

import com.olabode.wilson.dagger.di.ViewModelKey;
import com.olabode.wilson.dagger.ui.main.posts.PostViewModel;
import com.olabode.wilson.dagger.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by OLABODE WILSON on 2020-02-21.
 */
@Module
public abstract class MainViewModelsModule {
    @IntoMap
    @Binds
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);


    @IntoMap
    @Binds
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindPostViewModel(PostViewModel viewModel);

}
