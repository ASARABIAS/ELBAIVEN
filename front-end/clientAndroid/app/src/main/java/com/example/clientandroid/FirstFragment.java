package com.example.clientandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clientandroid.API.category.CategoryAdapter;
import com.example.clientandroid.API.category.model.Category;
import com.example.clientandroid.API.category.repository.CategoryAPIService;
import com.example.clientandroid.databinding.FragmentFirstBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragment extends Fragment implements Callback<ArrayList<Category>> {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Call<ArrayList<Category>> call = CategoryAdapter.getCategoryAPIService().getCategories();
        call.enqueue(this);

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
        if(response.isSuccessful()){
           ArrayList<Category> listCategories = response.body();
           Log.d("OnResponse Category","Size of category"+listCategories.size());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Category>> call, Throwable t) {

    }
}