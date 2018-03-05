package com.kvest.hierarchicalrooms;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.kvest.hierarchicalrooms.dao.AppDao;
import com.kvest.hierarchicalrooms.entity.ModuleEntity;
import com.kvest.hierarchicalrooms.entity.RepositoryEntity;
import com.kvest.hierarchicalrooms.entity.UserEntity;

/**
 * Created by kvest on 3/4/18.
 */

@Database(entities = {UserEntity.class, RepositoryEntity.class, ModuleEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    @VisibleForTesting
    public static final String DATABASE_NAME = "app-db";

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = buildDatabase(context.getApplicationContext());
                }
            }
        }

        return instance;
    }

    private static AppDatabase buildDatabase(Context appContext) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME).build();
    }

    public abstract AppDao appDao();
}
