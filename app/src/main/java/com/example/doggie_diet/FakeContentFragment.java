package com.example.doggie_diet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FakeContentFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fake_content, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewFakeContent);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Add sample data with drawable resources
        productList = new ArrayList<>();
        productList.add(new Product("Dog Nutrition & Diet", R.drawable.content_5));
        productList.add(new Product("Canine Nutrition", R.drawable.content_3));
        productList.add(new Product("Try Volhard", R.drawable.content_4));
        productList.add(new Product("Try these steps", R.drawable.content_2));
        productList.add(new Product("Helpful tips from CHEWY", R.drawable.content_1));
        productList.add(new Product("Feeding guide ep 304", R.drawable.content_6));
        // Add more contents as needed

        // Provide a no-op implementation for OnItemClickListener
        adapter = new ProductAdapter(productList, getContext(), product -> {
            // No-op or empty implementation
        });
        recyclerView.setAdapter(adapter);

        return view;
    }
}
