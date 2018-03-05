package com.kvest.hierarchicalrooms.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by kvest on 3/4/18.
 */
@Entity(tableName = "users")
public class UserEntity {
    @PrimaryKey
    public long id;

    @ColumnInfo(name = "user_name")
    public String name;

    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
