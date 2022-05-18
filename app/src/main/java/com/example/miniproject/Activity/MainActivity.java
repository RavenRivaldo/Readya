package com.example.miniproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miniproject.API.Serverbuku;
import com.example.miniproject.Adapter.BukuAdapter;
import com.example.miniproject.Model.ModelBuku;
import com.example.miniproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcy;
    private BukuAdapter bukuAdapter;
    private GridLayoutManager glm;
    private SearchView cari;
    private Button btn;
    private List<ModelBuku> modelBukus = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcy = findViewById(R.id.rcy);
        glm = new GridLayoutManager(this,2);
        rcy.setLayoutManager(glm);
        bukuAdapter = new BukuAdapter(this, modelBukus);
        rcy.setAdapter(bukuAdapter);
        cari = findViewById(R.id.cari);
        cari.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        btn = findViewById(R.id.btn);
        //btn.setOnClickListener(new View.OnClickListener() {
         //   @Override
            //public void onClick(View view) {
              //  Intent intent = new Intent(MainActivity.this, HalamanBuku.class);
                //startActivity(intent);
            //}
        //});
        showDataBuku();

    }

    private void showDataBuku() {
        Serverbuku.getSelect().selectBuku().enqueue(new Callback<List<ModelBuku>>() {
            @Override
            public void onResponse(Call<List<ModelBuku>> call, Response<List<ModelBuku>> response) {
                if (response.isSuccessful() && response.body()!= null){
                    modelBukus.addAll(response.body());
                    bukuAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ModelBuku>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}