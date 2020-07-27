package com.lyecdevelopers.learncomputers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lyecdevelopers.learncomputers.R;
import com.lyecdevelopers.learncomputers.adapters.NotesAdapter;
import com.lyecdevelopers.learncomputers.interfaces.NotesItemsListener;
import com.lyecdevelopers.learncomputers.models.Notes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NotesItemsListener {

    private static final String TAG = "MainActivity";
    RecyclerView mRecyclerView;
    NotesAdapter mNotesAdapter;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);

        initToolbar(toolbar);
        setData();
        initRecycler();

    }

    private void initToolbar(Toolbar toolbar) {
        if (getSupportActionBar() == null) {
            setSupportActionBar(toolbar);


            getSupportActionBar().setTitle("Home");


        }
    }

    private void setData() {


        List<Notes> notesList = new ArrayList<>();

        Notes notes_1 = new Notes();
        notes_1.setTitle("Basics of Computers- Home");
        notes_1.setDescrpiton(" Basics of Computers Tutorial\n" +
                "            A computer is an electronic device that receives input, stores or processes the input as per user instructions and provides output in desired format. Computers have become an integral part of our lives because they can accomplish easy tasks repeatedly without getting bored and complex ones repeatedly without committing errors. In this tutorial we will discuss in detail about the different parts of computer that enable it to carry out tasks efficiently and correctly. We will also discuss about microprocessors, the brain of computers, which actually do all the assigned tasks.\n" +
                "            Audience\n" +
                "This tutorial is designed for anyone who wants to understand the basic concepts of what a computer is and how it functions.\n" +
                "\n" +
                "Prerequisites\n" +
                "There are no prerequisites for this course except a desire to learn about how a computer works. Having worked on a computer would be an added advantage in completing the tutorial.\n" +
                "       ");


        Notes notes_2 = new Notes();
        notes_2.setTitle("Basics of Computers - Introduction");
        notes_2.setDescrpiton(" Basics of Computers Tutorial\n" +
                "            A computer is an electronic device that receives input, stores or processes the input as per user instructions and provides output in desired format. Computers have become an integral part of our lives because they can accomplish easy tasks repeatedly without getting bored and complex ones repeatedly without committing errors. In this tutorial we will discuss in detail about the different parts of computer that enable it to carry out tasks efficiently and correctly. We will also discuss about microprocessors, the brain of computers, which actually do all the assigned tasks.\n" +
                "            Audience\n" +
                "This tutorial is designed for anyone who wants to understand the basic concepts of what a computer is and how it functions.\n" +
                "\n" +
                "Prerequisites\n" +
                "There are no prerequisites for this course except a desire to learn about how a computer works. Having worked on a computer would be an added advantage in completing the tutorial.\n" +
                "       ");

        Notes notes_3 = new Notes();
        notes_3.setTitle("Basics of Computers - Classifications");
        notes_3.setDescrpiton(" Basics of Computers Tutorial\n" +
                "            A computer is an electronic device that receives input, stores or processes the input as per user instructions and provides output in desired format. Computers have become an integral part of our lives because they can accomplish easy tasks repeatedly without getting bored and complex ones repeatedly without committing errors. In this tutorial we will discuss in detail about the different parts of computer that enable it to carry out tasks efficiently and correctly. We will also discuss about microprocessors, the brain of computers, which actually do all the assigned tasks.\n" +
                "            Audience\n" +
                "This tutorial is designed for anyone who wants to understand the basic concepts of what a computer is and how it functions.\n" +
                "\n" +
                "Prerequisites\n" +
                "There are no prerequisites for this course except a desire to learn about how a computer works. Having worked on a computer would be an added advantage in completing the tutorial.\n" +
                "       ");


        notesList.add(notes_1);
        notesList.add(notes_2);
        notesList.add(notes_3);

        Log.d(TAG, "setData: "+notesList);


        mNotesAdapter = new NotesAdapter(notesList, this);

    }

    private void initRecycler() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mNotesAdapter);
    }

    @Override
    public void onClick(Notes notes) {
        Intent intent = new Intent(MainActivity.this, SingleNotesDetail.class);
        intent.putExtra("title", notes.getTitle());
        intent.putExtra("description", notes.getDescrpiton());
        startActivity(intent);
        finish();
    }
}