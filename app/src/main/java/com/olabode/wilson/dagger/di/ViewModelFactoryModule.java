package com.olabode.wilson.dagger.di;

import androidx.lifecycle.ViewModelProvider;

import com.olabode.wilson.dagger.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Created by OLABODE WILSON on 2020-02-19.
 */
@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModel(ViewModelProviderFactory viewModelProviderFactory);

}
