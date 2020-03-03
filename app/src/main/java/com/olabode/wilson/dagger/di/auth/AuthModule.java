package com.olabode.wilson.dagger.di.auth;

import com.olabode.wilson.dagger.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */
@Module
public class AuthModule {
    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}
