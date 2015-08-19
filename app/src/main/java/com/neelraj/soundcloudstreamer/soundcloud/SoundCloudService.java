package com.neelraj.soundcloudstreamer.soundcloud;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Fisher on 6/20/15.
 */
public interface SoundCloudService {

    String CLIENT_ID = "17302a9d130ab9ade01577a0fd5ae52c";

    @GET("/tracks?client_id="+CLIENT_ID)
    void searchSongs(@Query("q") String query, Callback<List<Track>> cb);

    @GET("/tracks?client_id="+CLIENT_ID)
    void getRecentSongs(@Query("created_at[from]") String date, Callback<List<Track>> cb);
}
