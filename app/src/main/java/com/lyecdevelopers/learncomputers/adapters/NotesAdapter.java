package com.lyecdevelopers.learncomputers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lyecdevelopers.learncomputers.R;
import com.lyecdevelopers.learncomputers.interfaces.NotesItemsListener;
import com.lyecdevelopers.learncomputers.models.Notes;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesAdapterViewHolder> {


    private List<Notes> notesList;
    NotesItemsListener listener;

    public NotesAdapter(List<Notes> notesList, NotesItemsListener listener) {
        this.notesList = notesList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public NotesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesAdapterViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.single_notes_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapterViewHolder holder, int position) {
        holder.onBind(notesList.get(position));

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public  class NotesAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mDescription;

        public NotesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.txttitle);
        }

        public void onBind(Notes notes) {
            mTitle.setText(notes.getTitle());
            itemView.setOnClickListener(view -> {
                listener.onClick(notes);
            });
        }
    }
}
