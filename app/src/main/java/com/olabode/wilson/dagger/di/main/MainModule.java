package com.olabode.wilson.dagger.di.main;

import com.olabode.wilson.dagger.network.main.MainAPi;
import com.olabode.wilson.dagger.ui.main.posts.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by OLABODE WILSON on 2020-02-21.
 */
@Module
public class MainModule {
    @Provides
    static MainAPi provideMainAPi(Retrofit retrofit) {
        return retrofit.create(MainAPi.class);
    }


    @Provides
    static PostsRecyclerAdapter providePostsRecyclerAdapter() {
        return new PostsRecyclerAdapter();
    }
}
