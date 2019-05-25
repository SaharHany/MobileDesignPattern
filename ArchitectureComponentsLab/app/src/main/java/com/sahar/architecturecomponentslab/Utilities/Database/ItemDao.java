package com.sahar.architecturecomponentslab.Utilities.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sahar.architecturecomponentslab.Model.Item;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM Item")
    public List<Item> retreiveAllItems();

    @Query("SELECT * FROM Item WHERE item_name = :name")
    public Item retreiveByName(String name);

    @Insert
    public void insertItem(Item item);

    @Delete
    public void deleteItem(Item item);
}
