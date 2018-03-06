package com.kvest.hierarchicalrooms.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by kvest on 3/4/18.
 */
@Entity(tableName = "modules",
        foreignKeys = @ForeignKey(entity = RepositoryEntity.class,
                parentColumns = "id",
                childColumns = "repo_id",
                onDelete = CASCADE))
public class ModuleEntity {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public long id;

    @ColumnInfo(name = "module_name")
    public String name;

    @ColumnInfo(name = "repo_id")
    public long repoId;

    public ModuleEntity(long id, String name, long repoId) {
        this.id = id;
        this.name = name;
        this.repoId = repoId;
    }
}
