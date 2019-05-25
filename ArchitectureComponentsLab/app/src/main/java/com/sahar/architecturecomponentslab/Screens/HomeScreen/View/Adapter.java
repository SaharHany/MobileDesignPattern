package com.sahar.architecturecomponentslab.Screens.HomeScreen.View;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sahar.architecturecomponentslab.Model.Item;
import com.sahar.architecturecomponentslab.R;
import com.sahar.architecturecomponentslab.Screens.HomeScreen.ViewModel.HomeViewModel;
import com.sahar.architecturecomponentslab.databinding.ItemcardviewBinding;
import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    List<Item> itemList ;
    Context context ;
    HomeViewModel viewModel ;

    public Adapter(Context context, HomeViewModel homeViewModel) {
        this.context = context;
        this.viewModel = homeViewModel ;
        this.itemList = this.viewModel.retreiveAllFromDataBase();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemcardviewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.itemcardview, viewGroup, false);

        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = itemList.get(i);
        viewHolder.binding.setItem(item);
        ImageView imageView = viewHolder.binding.itemImg ;
        Glide.with(context)
                .load(item.getItem_image_url())
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemcardviewBinding binding ;
        public ViewHolder(ItemcardviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding  ;
        }
    }


}
