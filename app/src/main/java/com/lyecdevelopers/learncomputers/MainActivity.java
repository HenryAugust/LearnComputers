package com.lyecdevelopers.learncomputers;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lyecdevelopers.learncomputers.adapters.NotesAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView mRecyclerView;
    NotesAdapter mNotesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        initRecycler();
        setData();

    }

    private void setData() {

        String[] titles = getResources().getStringArray(R.array.title_strings);
        String[] description = getResources().getStringArray(R.array.descriptions_strings);

        List<String> list = Arrays.asList(titles);
        Log.d(TAG, "setData: "+list.toString());

        List<String> list_description = Arrays.asList(description);
        Log.d(TAG, "setData: "+list_description);

    }

    private void initRecycler() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mNotesAdapter);
    }
}