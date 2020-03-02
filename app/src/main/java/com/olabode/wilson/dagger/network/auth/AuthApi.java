package com.olabode.wilson.dagger.network.auth;

import com.olabode.wilson.dagger.models.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */

public interface AuthApi {
    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}
