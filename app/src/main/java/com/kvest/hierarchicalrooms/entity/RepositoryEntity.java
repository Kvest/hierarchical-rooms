package com.kvest.hierarchicalrooms.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by kvest on 3/4/18.
 */
@Entity(tableName = "repos",
        foreignKeys = @ForeignKey(entity = UserEntity.class,
                parentColumns = "id",
                childColumns = "owner_id",
                onDelete = CASCADE))
public class RepositoryEntity {
    @PrimaryKey
    public long id;

    @ColumnInfo(name = "repo_name")
    public String name;

    @ColumnInfo(name = "owner_id")
    public long ownerId;

    public RepositoryEntity(long id, String name, long ownerId) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
    }
}