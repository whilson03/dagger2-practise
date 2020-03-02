package com.olabode.wilson.dagger.di;

import com.olabode.wilson.dagger.di.auth.AuthModule;
import com.olabode.wilson.dagger.di.auth.AuthViewModelsModule;
import com.olabode.wilson.dagger.di.main.MainFragmentBuildersModule;
import com.olabode.wilson.dagger.di.main.MainModule;
import com.olabode.wilson.dagger.di.main.MainViewModelsModule;
import com.olabode.wilson.dagger.ui.auth.AuthActivity;
import com.olabode.wilson.dagger.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by OLABODE WILSON on 2020-02-19.
 */

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {AuthViewModelsModule.class, AuthModule.class})
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class,
                    MainModule.class}
    )
    abstract MainActivity contributeMainActivity();


}
