package com.example.clientandroid.API.category;

import com.example.clientandroid.API.category.repository.CategoryAPIService;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryAdapter {
    private static CategoryAPIService categoryAPIService;
    public static  CategoryAPIService getCategoryAPIService(){
        // Creamos un interceptor y le indicamos el log level a usar
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Asociamos el interceptor a las peticiones
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        if (categoryAPIService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://localhost:8080/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            categoryAPIService = retrofit.create(CategoryAPIService.class);
        }
        return categoryAPIService;
    }
}
