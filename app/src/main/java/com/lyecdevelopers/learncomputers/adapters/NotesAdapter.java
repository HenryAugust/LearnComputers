package com.lyecdevelopers.learncomputers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lyecdevelopers.learncomputers.R;
import com.lyecdevelopers.learncomputers.models.Notes;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesAdapterViewHolder> {


    List<Notes> notesList;

    public NotesAdapter(List<Notes> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_notes_items, parent, false);
        return new NotesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapterViewHolder holder, int position) {
        Notes notes = notesList.get(position);
        holder.mTitle.setText(notes.getTitle());

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NotesAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;

        public NotesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.txttitle);

        }
    }
}
