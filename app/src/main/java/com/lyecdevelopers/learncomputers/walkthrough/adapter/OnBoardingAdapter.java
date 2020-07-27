package com.lyecdevelopers.learncomputers.walkthrough.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lyecdevelopers.learncomputers.R;
import com.lyecdevelopers.learncomputers.walkthrough.model.OnBoardingItem;

import java.util.List;


public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder> {

    List<OnBoardingItem> onBoardingItems;

    public OnBoardingAdapter(List<OnBoardingItem> onBoardingItems) {
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_container_onboarding, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle;
        private TextView txtDescription;
        private ImageView imgOnBoarding;

        OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgOnBoarding = itemView.findViewById(R.id.imgOnboarding);
        }

        void setOnBoardingData(OnBoardingItem onBoardingItem) {
            txtTitle.setText(onBoardingItem.getTitle());
            txtDescription.setText(onBoardingItem.getDescription());
            imgOnBoarding.setImageResource(onBoardingItem.getImage());
        }
    }
}
