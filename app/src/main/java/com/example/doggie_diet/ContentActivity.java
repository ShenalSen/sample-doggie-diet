package com.example.doggie_diet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContentActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set up ViewPager2 with the adapter
        viewPager.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(), getLifecycle()));

        // Handle navigation item selection
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_shop) {
                viewPager.setCurrentItem(0);
                return true;
            } else if (id == R.id.navigation_whats_new) { // This now points to the FakeContentFragment
                viewPager.setCurrentItem(1);
                return true;
            } else if (id == R.id.navigation_profile) {
                viewPager.setCurrentItem(2);
                return true;
            }
            return false;
        });

        // Sync ViewPager2 with BottomNavigationView
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_shop);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_whats_new);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
                        break;
                }
            }
        });
    }

    private class ContentPagerAdapter extends FragmentStateAdapter {

        public ContentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new ShopFragment();
                case 1:
                    return new FakeContentFragment(); // Replaces WhatsNewFragment
                case 2:
                    return new ProfileFragment();
                default:
                    return new ShopFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 3; // No change needed here since we're just replacing a fragment
        }
    }
}
