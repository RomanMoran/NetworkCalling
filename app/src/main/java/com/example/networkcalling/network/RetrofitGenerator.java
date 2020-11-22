package com.example.networkcalling.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGenerator {

    private final String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder().addInterceptor(logging);

    private Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create());

    public Retrofit buildRetrofit() {
        return retrofitBuilder.build();
    }

}
