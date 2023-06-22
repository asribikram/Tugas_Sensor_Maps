package com.example.tugassensormaps;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

//10120080
//habib asrib ikram
//IF-2

public class Viewpager extends AppCompatActivity {
    Button BtnNext;
    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;
    private static final long SPLASH_DELAY = 2000; // Waktu penundaan dalam milidetik (misalnya 2000 = 2 detik)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        viewPager2 = findViewById(R.id.viewpager);
        int[] images = {R.drawable.makanan, R.drawable.minuman, R.drawable.harga};
        String[] heading = {"Makanan", "Minuman", "Harga"};
        String[] desc = {"Makanan yang ada di" +
                "rekomendasi resto ini" +
                " rasanya ga kalah enak" +
                " sama di restoran " +
                "bintang 5", "Tersedia berbagai macam minuman yang " +
                "segar" +
                " dan fresh", "Harganya terjangkau dan murah"};

        viewPagerItemArrayList = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i], heading[i], desc[i]);
            viewPagerItemArrayList.add(viewPagerItem);
        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);
        viewPager2.setAdapter(vpAdapter);

        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        Button btnNext = findViewById(R.id.btnNext); // Mendapatkan referensi tombol "Next"

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logika yang akan dijalankan saat tombol "Next" ditekan
                startActivity(new Intent(Viewpager.this, MainActivity.class));
                finish();
            }
        });
    }
}
