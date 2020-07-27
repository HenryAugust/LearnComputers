package com.lyecdevelopers.learncomputers.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        //initialise toolbar
        initToolbar(toolbar);


        //set data
        setData(mTitle, mDescripiton);


    }

    private void initToolbar( Toolbar toolbar) {
        if (getSupportActionBar() == null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Details");
            toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
            toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);

        }
    }

    private void setData(TextView mTitle,TextView mDescripiton) {
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        mTitle.setText(title);
        mDescripiton.setText(description);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            super.onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
