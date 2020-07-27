package com.lyecdevelopers.learncomputers.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lyecdevelopers.learncomputers.R;

public class SingleNotesDetail extends AppCompatActivity {

    TextView mTitle;
    TextView mDescripiton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_details);

        mTitle = findViewById(R.id.txtTitle);
        mDescripiton = findViewById(R.id.txtDescription);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        mTitle.setText(title);
        mDescripiton.setText(description);

    }
}
