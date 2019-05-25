package com.sahar.architecturecomponentslab.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sahar.architecturecomponentslab.BR;

import io.reactivex.annotations.NonNull;

@Entity
public class Item extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    public int item_ID ;

    public String item_name;

    public String item_description ;

    public String item_image_url ;

    public Item() {
    }

    public int getItem_ID() {
        return item_ID;
    }

    public void setItem_ID(int item_ID) {
        this.item_ID = item_ID;
       // notifyPropertyChanged();
    }

    @Bindable
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
        notifyPropertyChanged(BR.item_name);
    }

    @Bindable
    public String getItem_image_url() {
        return item_image_url;
    }

    public void setItem_image_url(String item_image_url) {
        this.item_image_url = item_image_url;
        notifyPropertyChanged(BR.item_image_url);
   }

    @Bindable
    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
        notifyPropertyChanged(BR.item_description);
    }
}
