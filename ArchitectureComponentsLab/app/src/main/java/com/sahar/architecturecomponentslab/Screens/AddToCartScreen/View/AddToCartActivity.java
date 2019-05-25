package com.sahar.architecturecomponentslab.Screens.AddToCartScreen.View;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sahar.architecturecomponentslab.Model.Item;
import com.sahar.architecturecomponentslab.R;
import com.sahar.architecturecomponentslab.Screens.AddToCartScreen.ViewModel.AddToCartViewModel;
import com.sahar.architecturecomponentslab.Utilities.Database.DatabaseRoom;
import com.sahar.architecturecomponentslab.databinding.ActivityAddToCartBinding;

public class AddToCartActivity extends AppCompatActivity {

    ActivityAddToCartBinding addToCartBinding ;
    AddToCartViewModel viewModel ;
    Item item ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        initComponents();
    }

    public void initComponents() {
        item = new Item();
        item.setItem_image_url("https://cf5.s3.souqcdn.com/item/2018/02/20/30/77/37/55/item_XXL_30773755_111113756.jpg");
        DatabaseRoom databaseRoom = Room.databaseBuilder(getApplicationContext(), DatabaseRoom.class, "MyCart")
                .build();
        viewModel.setDatabaseRoom(databaseRoom);
        addToCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_to_cart);
        addToCartBinding.setItem(item);
        addToCartBinding.setView(this);
        initViewModel();
        addToCartBinding.addToCartBtn.setOnClickListener(v -> {
            viewModel.addToDataBase(this.item);
            finish();
        });
    }

    public void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddToCartViewModel.class);
    }


}
