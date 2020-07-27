package com.lyecdevelopers.learncomputers.walkthrough;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;
import com.lyecdevelopers.learncomputers.activities.MainActivity;
import com.lyecdevelopers.learncomputers.R;
import com.lyecdevelopers.learncomputers.walkthrough.adapter.OnBoardingAdapter;
import com.lyecdevelopers.learncomputers.walkthrough.model.OnBoardingItem;

import java.util.ArrayList;
import java.util.List;

public class WalkthroughActivity extends AppCompatActivity {

    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout layoutOnBoardingIndicators;
    private MaterialButton onBoardingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkthrough_activity);

        layoutOnBoardingIndicators = findViewById(R.id.layoutOnBoardingIndicators);
        onBoardingActionButton = findViewById(R.id.btnOnBoardingAction);

        setOnBoardingItemsData();

        ViewPager2 onBoardingViewPager = findViewById(R.id.onBoardingViewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

        setUpOnBoardingIndicators();
        setUpCurrentOnBoardingIndicator(0);
        onBoardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setUpCurrentOnBoardingIndicator(position);
            }
        });

        onBoardingActionButton.setOnClickListener(view -> {
            if (onBoardingViewPager.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                onBoardingViewPager.setCurrentItem(onBoardingViewPager.getCurrentItem() + 1);
            } else {
                startActivity(new Intent(WalkthroughActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void setOnBoardingItemsData() {

        List<OnBoardingItem> onBoardingItems = new ArrayList<>();

        OnBoardingItem onOnlineShopItem = new OnBoardingItem();
        onOnlineShopItem.setTitle("We Offer Quality and Fresh groceries");
        onOnlineShopItem.setDescription(getResources().getString(R.string.txtLongLorem));
        onOnlineShopItem.setImage(R.drawable.images_1);

        OnBoardingItem onDeliveryItem = new OnBoardingItem();
        onDeliveryItem.setTitle("We deliver it directly to you from the farms");
        onDeliveryItem.setDescription(getResources().getString(R.string.txtLongLorem));
        onDeliveryItem.setImage(R.drawable.images_2);

        OnBoardingItem onShoppingItem = new OnBoardingItem();
        onShoppingItem.setTitle("Try us today with satisfaction");
        onShoppingItem.setDescription(getResources().getString(R.string.txtLongLorem));
        onShoppingItem.setImage(R.drawable.images_3);


        onBoardingItems.add(onOnlineShopItem);
        onBoardingItems.add(onDeliveryItem);
        onBoardingItems.add(onShoppingItem);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);

    }

    private void setUpOnBoardingIndicators() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {

            indicators[i] = new ImageView(WalkthroughActivity.this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    WalkthroughActivity.this,
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicators.addView(indicators[i]);
        }
    }


    @SuppressLint("SetTextI18n")
    private void setUpCurrentOnBoardingIndicator(int index) {
        int childCount = layoutOnBoardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnBoardingIndicators.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        WalkthroughActivity.this,
                        R.drawable.onboarding_indicatior_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        WalkthroughActivity.this,
                        R.drawable.onboarding_indicator_inactive
                ));
            }

        }

        if (index == onBoardingAdapter.getItemCount() - 1) {
            onBoardingActionButton.setText("START");
        } else {
            onBoardingActionButton.setText("NEXT");
        }

    }

}
