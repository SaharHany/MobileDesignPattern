package com.sahar.architecturecomponentslab.Screens.HomeScreen.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.sahar.architecturecomponentslab.Model.Item;
import com.sahar.architecturecomponentslab.Utilities.Database.DatabaseRoom;
import com.sahar.architecturecomponentslab.Utilities.Database.ItemDao;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    DatabaseRoom databaseRoom ;
    ItemDao itemDao ;

    public void setDatabaseRoom(DatabaseRoom databaseRoom){
        this.databaseRoom = databaseRoom ;
        this.itemDao = this.databaseRoom.itemDao();
    }
    public List<Item> retreiveAllFromDataBase(){
        return this.itemDao.retreiveAllItems();
    }

}
