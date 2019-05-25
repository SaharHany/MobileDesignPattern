package com.sahar.architecturecomponentslab.Screens.HomeScreen.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil ;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sahar.architecturecomponentslab.Model.Item;
import com.sahar.architecturecomponentslab.R;
import com.sahar.architecturecomponentslab.Screens.AddToCartScreen.View.AddToCartActivity;
import com.sahar.architecturecomponentslab.Screens.HomeScreen.ViewModel.HomeViewModel;
import com.sahar.architecturecomponentslab.databinding.ActivityMainBinding;

import java.util.ArrayList;

//import com.sahar.architecturecomponentslab.Screens.HomeScreen.View.databinding.ActivityHomeBinding;
public class HomeActivity extends AppCompatActivity {

    public   Adapter adapter ;
    public   RecyclerView recyclerView ;
    public   RecyclerView.LayoutManager layoutManager ;
    public   ActivityMainBinding binding;
    public   HomeViewModel viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();
        initComponents();

    }

    public void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    public void initComponents() {
        binding.addFAB.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AddToCartActivity.class);
            startActivity(intent);
        });

        initRecyclerView();
    }

    public void initRecyclerView() {
        adapter = new Adapter(this , viewModel);
        recyclerView = findViewById(R.id.recView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        binding.unbind();
        super.onDestroy();
    }

}
