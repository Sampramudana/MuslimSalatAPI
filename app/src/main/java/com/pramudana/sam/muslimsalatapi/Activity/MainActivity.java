package com.pramudana.sam.muslimsalatapi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView;

import com.pramudana.sam.muslimsalatapi.Model.ItemsItem;
import com.pramudana.sam.muslimsalatapi.Model.Response;
import com.pramudana.sam.muslimsalatapi.Network.ApiService;
import com.pramudana.sam.muslimsalatapi.Network.InstanceRetrofit;
import com.pramudana.sam.muslimsalatapi.R;

import java.io.DataInput;
import java.util.List;

import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    TextView shubuh, shurooq, dzuhur, ashar, maghrib, isya, state, city, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Inlitialize Widget to Variable
        shubuh = findViewById(R.id.shubuh);
        shurooq = findViewById(R.id.shurooq);
        dzuhur = findViewById(R.id.dzuhur);
        ashar = findViewById(R.id.ashar);
        maghrib = findViewById(R.id.maghrib);
        isya = findViewById(R.id.isya);
        state = findViewById(R.id.state);
        city = findViewById(R.id.city);
        date = findViewById(R.id.date);

        getData();
    }

    private void getData() {
        ApiService api = InstanceRetrofit.getInstance();
        retrofit2.Call<Response> call = api.readJadwalSholat();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(retrofit2.Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().getStatusCode() == 1){
                    city.setText(response.body().getCity());
                    state.setText(response.body().getState());

                    List<ItemsItem> jadwalSholat = response.body().getItems();
                    shubuh.setText(jadwalSholat.get(0).getFajr());
                    shurooq.setText(jadwalSholat.get(0).getShurooq());
                    dzuhur.setText(jadwalSholat.get(0).getDhuhr());
                    ashar.setText(jadwalSholat.get(0).getAsr());
                    maghrib.setText(jadwalSholat.get(0).getMaghrib());
                    isya.setText(jadwalSholat.get(0).getIsha());
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Response> call, Throwable t) {

            }
        });
    }
}
