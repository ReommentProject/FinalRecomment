package com.example.recomment;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUsers();
    }

    private void getUsers() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        Api api = RetrofitClient.getMyApi();
        Call<List<Content>> call = RetrofitClient.getInstance().getMyApi().getMainContent();

        call.enqueue(new Callback<List<Content>>() {
            @Override
            public void onResponse(Call<List<Content>> call, Response<List<Content>> response) {
                System.out.println("responpon");

                RecyclerView recyclerView;
                RecyclerAdapter recyclerAdapter;
                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(layoutManager);
                List<Content> contentList = response.body();
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), contentList);
                recyclerView.setAdapter(recyclerAdapter);


            }

            @Override
            public void onFailure(Call<List<Content>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured in get", Toast.LENGTH_LONG).show();
            }

        });
    }
}