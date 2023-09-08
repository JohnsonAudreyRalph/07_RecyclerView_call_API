package com.example.a07_recyclerview_call_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a07_recyclerview_call_api.adapter.User_Adapter;
import com.example.a07_recyclerview_call_api.api.API_Service;
import com.example.a07_recyclerview_call_api.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecyclerView;
    private List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView = findViewById(R.id.RecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView.addItemDecoration(dividerItemDecoration);
        mListUser = new ArrayList<>();
        Call_API();
    }

    private void Call_API(){
        API_Service.api_service.gesListUser(1).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mListUser = response.body();
                User_Adapter userAdapter = new User_Adapter(mListUser);
                RecyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Có lỗi gì đó", Toast.LENGTH_SHORT).show();
            }
        });
    }
}