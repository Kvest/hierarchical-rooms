package com.kvest.hierarchicalrooms;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.kvest.hierarchicalrooms.dao.AppDao;
import com.kvest.hierarchicalrooms.entity.ModuleEntity;
import com.kvest.hierarchicalrooms.entity.RepositoryEntity;
import com.kvest.hierarchicalrooms.entity.UserEntity;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.*;

/**
 * Created by kvest on 3/5/18.
 */
@RunWith(AndroidJUnit4.class)
public class RoomTest {
    private final static UserEntity USER1 = new UserEntity(1, "first");
    private final static UserEntity USER2 = new UserEntity(2, "second");
    private final static UserEntity USER3 = new UserEntity(3, "third");
    private final static RepositoryEntity REPO1 = new RepositoryEntity(10, "repo1", 1);
    private final static RepositoryEntity REPO2 = new RepositoryEntity(11, "repo2", 1);
    private final static RepositoryEntity REPO3 = new RepositoryEntity(21, "repo3", 2);
    private final static ModuleEntity MODULE1 = new ModuleEntity(101, "module_101", 10);
    private final static ModuleEntity MODULE2 = new ModuleEntity(102, "module_102", 10);
    private final static ModuleEntity MODULE3 = new ModuleEntity(211, "module_211", 21);
    private final static ModuleEntity MODULE4 = new ModuleEntity(212, "module_212", 21);

    private AppDatabase database;
    private AppDao appDao;

    @Before
    public void initDb() throws Exception {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AppDatabase.class)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build();

        appDao = database.appDao();

        //we will test only queries - so add all the test data in Before
        appDao.insertUsers(USER1, USER2, USER3);
        appDao.insertRepos(REPO1, REPO2, REPO3);
        appDao.insertModules(MODULE1, MODULE2, MODULE3, MODULE4);
    }

    @Test
    public void testDao() {
        //check all data exists
        assertEquals(3, appDao.getAllUsers().size());
        assertEquals(3, appDao.getAllRepos().size());
        assertEquals(4, appDao.getAllModules().size());

        appDao.deleteUsers(USER1, USER2, USER3);
        assertEquals(0, appDao.getAllUsers().size());
        assertEquals(0, appDao.getAllRepos().size());
        assertEquals(0, appDao.getAllModules().size());
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }
}
