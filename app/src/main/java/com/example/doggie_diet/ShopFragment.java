//
//package com.example.doggie_diet;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ShopFragment extends Fragment {
//
//    private RecyclerView recyclerView;
//    private ProductAdapter adapter;
//    private List<Product> productList;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_shop, container, false);
//
//        recyclerView = view.findViewById(R.id.recyclerViewShop);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
//
//        // Add sample data using drawable resources
//        productList = new ArrayList<>();
//        productList.add(new Product("Woof - 4750 LKR", R.drawable.dog_food_1));
//        productList.add(new Product("Petable - 2000 LKR", R.drawable.dog_food_2));
//        productList.add(new Product("Big Paw 9000 LKR", R.drawable.dog_food_3));
//        productList.add(new Product("K9 Dog 10750 LKR", R.drawable.dog_food_4));
//        productList.add(new Product("HPF Dog 12000 LKR", R.drawable.dog_food_5));
//        productList.add(new Product("Best Breed 12800 LKR", R.drawable.dog_food_6));
//        // Add more products as needed
//
//        adapter = new ProductAdapter(productList, getContext());
//        recyclerView.setAdapter(adapter);
//
//        return view;
//    }
//}
//

package com.example.doggie_diet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> productList;
    private Button cartButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewShop);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Initialize the cart button
        cartButton = view.findViewById(R.id.cartbutton);
        cartButton.setOnClickListener(v -> {
            // Navigate to CartActivity when the cart button is clicked
            Intent intent = new Intent(getContext(), CartActivity.class);
            startActivity(intent);
        });

        // Add sample data using drawable resources
        productList = new ArrayList<>();
        productList.add(new Product("Woof - 4750 LKR", R.drawable.dog_food_1));
        productList.add(new Product("Petable - 2000 LKR", R.drawable.dog_food_2));
        productList.add(new Product("Big Paw 9000 LKR", R.drawable.dog_food_3));
        productList.add(new Product("K9 Dog 10750 LKR", R.drawable.dog_food_4));
        productList.add(new Product("HPF Dog 12000 LKR", R.drawable.dog_food_5));
        productList.add(new Product("Best Breed 12800 LKR", R.drawable.dog_food_6));

        // Initialize the adapter with click listener for "Add to Cart"
        adapter = new ProductAdapter(productList, getContext(), product -> {
            Cart.getInstance().addToCart(product);
        });

        recyclerView.setAdapter(adapter);

        return view;
    }
}
