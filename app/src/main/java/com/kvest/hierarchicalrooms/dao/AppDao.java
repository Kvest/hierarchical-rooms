package com.kvest.hierarchicalrooms.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.kvest.hierarchicalrooms.entity.ModuleEntity;
import com.kvest.hierarchicalrooms.entity.RepositoryEntity;
import com.kvest.hierarchicalrooms.entity.UserEntity;
import com.kvest.hierarchicalrooms.model.UserWithRepos;

import java.util.List;

/**
 * Created by kvest on 3/4/18.
 */

@Dao
public abstract class AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertUsers(UserEntity... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRepos(RepositoryEntity... repos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertModules(ModuleEntity... modules);

    @Delete
    public abstract void deleteUsers(UserEntity... users);

    @Delete
    public abstract void deleteRepos(RepositoryEntity... repos);

    @Delete
    public abstract void deleteModules(ModuleEntity... modules);

    @Query("SELECT * FROM users")
    public abstract List<UserEntity> getAllUsers();

    @Query("SELECT * FROM repos")
    public abstract List<RepositoryEntity> getAllRepos();

    @Query("SELECT * FROM modules")
    public abstract List<ModuleEntity> getAllModules();

    @Query("SELECT * from users")
    public abstract List<UserWithRepos> getUsersWithRepos();
}
