package com.example.newmusicapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.newmusicapp.R;
import com.example.newmusicapp.databinding.ActivityUserBinding;
import com.example.newmusicapp.fragments.HomeFragment;
import com.example.newmusicapp.fragments.LibraryFragment;
import com.example.newmusicapp.fragments.SearchFragment;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linearLayout = findViewById(R.id.linearLayout);

        binding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, homeFragment);
                transaction.commit();
            }
        });

        binding.library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LibraryFragment libraryFragment = new LibraryFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, libraryFragment);
                transaction.commit();
            }
        });

        binding.searchMusics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = new SearchFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayout, searchFragment);
                transaction.commit();
            }
        });
    }
}