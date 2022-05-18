package com.example.miniproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miniproject.Model.ModelBuku;
import com.example.miniproject.R;

import java.util.List;

public class BukuAdapter extends RecyclerView.Adapter<UserViewHolder>{
    private Context context;
    private List<ModelBuku>modelBukuList;

    public BukuAdapter(Context context, List<ModelBuku> modelBukuList) {
        this.context = context;
        this.modelBukuList = modelBukuList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardbuku, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        ModelBuku modelBuku = modelBukuList.get(position);
        Glide.with(context).load(modelBuku.getImage()).into(holder.image);
        holder.kode.setText("Kode Buku = " + modelBuku.getKode());
        holder.judul.setText("Judul Buku = " + modelBuku.getNama());
        holder.matpel.setText("Mata Pelajaran = " + modelBuku.getMatpel());
        holder.url.setText("Url : " + modelBuku.getUrl());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Uri queryUrl = Uri.parse(modelBuku.getUrl());
                 Intent intent = new Intent(Intent.ACTION_VIEW, queryUrl);
                 context.startActivity(intent);

//                WebView webView = view.findViewById(R.id.urlbuku) ;
//                webView.setWebViewClient(new WebViewClient());
//                webView.loadUrl();
//                WebSettings settings = webView.getSettings();
//                settings.setJavaScriptEnabled(true);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelBukuList.size();
    }
}
class UserViewHolder extends RecyclerView.ViewHolder{
TextView kode, judul, matpel, url;
ImageView image;
Button btn;
WebView urlbuku;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
    kode = itemView.findViewById(R.id.kode);
    judul = itemView.findViewById(R.id.judul);
    matpel = itemView.findViewById(R.id.matpel);
    image = itemView.findViewById(R.id.image);
    url = itemView.findViewById(R.id.url);
    btn = itemView.findViewById(R.id.btn);
    urlbuku = itemView.findViewById(R.id.urlbuku);
    }
}
