package com.olabode.wilson.dagger.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by OLABODE WILSON on 2020-02-20.
 */
public class User {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("website")
    @Expose
    private String website;


    public User(String username, int id, String email, String website) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.website = website;
    }


    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
