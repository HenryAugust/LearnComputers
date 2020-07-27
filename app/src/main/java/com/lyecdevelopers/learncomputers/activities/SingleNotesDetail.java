package com.lyecdevelopers.learncomputers.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lyecdevelopers.learncomputers.R;

public class SingleNotesDetail extends AppCompatActivity {

    TextView mTitle;
    TextView mDescripiton;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_details);

        mTitle = findViewById(R.id.notes_title);
        mDescripiton = findViewById(R.id.notes_description);
        toolbar = findViewById(R.id.toolbar);


        if (getSupportActionBar() == null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("Details");
        }


        setData();


    }

    private void setData() {
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        mTitle.setText(title);
        mDescripiton.setText(description);
    }
}
