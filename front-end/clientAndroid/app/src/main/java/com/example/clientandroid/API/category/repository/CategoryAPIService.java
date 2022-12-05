package com.example.clientandroid.API.category.repository;
import com.example.clientandroid.API.category.model.Category;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
public interface CategoryAPIService {
    @GET("category")
    Call<ArrayList<Category>> getCategories();
}
