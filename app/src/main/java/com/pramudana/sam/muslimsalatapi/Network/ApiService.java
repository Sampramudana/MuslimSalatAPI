package com.pramudana.sam.muslimsalatapi.Network;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by sampramudana on 8/27/18.
 */

public interface ApiService {

    @GET("jakarta.json?key=d1aa7cdf5e8c0d2d7f1f47811497a732")
    Call<Response> readJadwalSholat();
}
