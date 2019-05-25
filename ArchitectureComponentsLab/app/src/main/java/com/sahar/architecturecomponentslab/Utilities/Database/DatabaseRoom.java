package com.sahar.architecturecomponentslab.Utilities.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sahar.architecturecomponentslab.Model.Item;

@Database(entities = {Item.class}, version = 1 , exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {
    public abstract ItemDao itemDao();
}
