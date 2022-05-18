package com.example.miniproject.API;

import com.example.miniproject.Model.ModelBuku;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Select {
    @GET("selectbuku.php")
    Call<List<ModelBuku>> selectBuku();
}
