package com.kvest.hierarchicalrooms.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.kvest.hierarchicalrooms.entity.ModuleEntity;
import com.kvest.hierarchicalrooms.entity.RepositoryEntity;

import java.util.List;

/**
 * Created by kvest on 3/6/18.
 */

public class RepositoryWithModules {
    @Embedded
    public RepositoryEntity repository;

    @Relation(parentColumn = "id", entityColumn = "repo_id", entity = ModuleEntity.class)
    public List<ModuleEntity> modules;
}
