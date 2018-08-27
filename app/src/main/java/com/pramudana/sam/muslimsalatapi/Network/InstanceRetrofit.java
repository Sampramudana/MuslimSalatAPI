package com.pramudana.sam.muslimsalatapi.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sampramudana on 8/27/18.
 */

public class InstanceRetrofit {
    private static final String Weburl = "http://muslimsalat.com/";

    private static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(Weburl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
