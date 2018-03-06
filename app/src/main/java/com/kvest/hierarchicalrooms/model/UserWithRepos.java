package com.kvest.hierarchicalrooms.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.kvest.hierarchicalrooms.entity.RepositoryEntity;
import com.kvest.hierarchicalrooms.entity.UserEntity;

import java.util.List;

/**
 * Created by kvest on 3/5/18.
 */

public class UserWithRepos {
    @Embedded
    public UserEntity user;

    @Relation(parentColumn = "id", entityColumn = "owner_id", entity = RepositoryEntity.class)
    public List<RepositoryWithModules> repos;
}
