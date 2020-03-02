package com.olabode.wilson.dagger.di.main;

import com.olabode.wilson.dagger.ui.main.posts.PostsFragment;
import com.olabode.wilson.dagger.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */
@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();


    @ContributesAndroidInjector
    abstract PostsFragment contributePostFragment();
}
