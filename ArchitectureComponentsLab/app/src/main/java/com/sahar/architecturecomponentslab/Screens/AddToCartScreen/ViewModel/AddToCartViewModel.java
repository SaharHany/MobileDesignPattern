package com.sahar.architecturecomponentslab.Screens.AddToCartScreen.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.view.ViewParent;

import com.sahar.architecturecomponentslab.Model.Item;
import com.sahar.architecturecomponentslab.Utilities.Database.DatabaseRoom;
import com.sahar.architecturecomponentslab.Utilities.Database.ItemDao;

public class AddToCartViewModel extends ViewModel {
    DatabaseRoom databaseRoom ;
    ItemDao itemDao ;

    public void setDatabaseRoom(DatabaseRoom databaseRoom){
        this.databaseRoom = databaseRoom ;
        this.itemDao = this.databaseRoom.itemDao();
    }
    public void addToDataBase(Item item){
        this.itemDao.insertItem(item);
    }

}
