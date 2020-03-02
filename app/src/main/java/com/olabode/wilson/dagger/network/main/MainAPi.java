package com.olabode.wilson.dagger.network.main;

import com.olabode.wilson.dagger.models.Post;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by OLABODE WILSON on 2020-02-21.
 */

public interface MainAPi {
    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(
            @Query("userId") int id
    );
}
