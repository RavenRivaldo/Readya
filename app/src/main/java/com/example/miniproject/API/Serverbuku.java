package com.example.miniproject.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Serverbuku {
    private static final String base_URL = "https://projectmew.000webhostapp.com/";
    private static Retrofit retrofit = null;

    public static Select getSelect(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Select.class);
    }
}
