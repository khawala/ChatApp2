package com.example.chatapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
    }
    public void emptyActiviyt(View v) {
        Intent numbersIntent = new Intent(this, EmptyActivity.class);
        startActivity(numbersIntent);
    }
    }