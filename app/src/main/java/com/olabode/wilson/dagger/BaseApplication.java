package com.olabode.wilson.dagger;

import com.olabode.wilson.dagger.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by OLABODE WILSON on 2020-02-19.
 */
public class BaseApplication extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
