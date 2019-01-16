package com.smart.digihome;

import android.app.Application;
import android.arch.persistence.room.Room;

import database.AppDataBase;

public class DigiHomeApp extends Application {

    private static DigiHomeApp digiHomeApp;
    private static AppDataBase appDataBase;
    public static DigiHomeApp getInstance(){
        if(digiHomeApp==null){
            digiHomeApp = new DigiHomeApp();
        }
        return digiHomeApp;
    }

    public AppDataBase getAppDatabase(){
        if(appDataBase == null) {
            appDataBase = AppDataBase.getDatabase(this);
        }
        return appDataBase;
    }

}
