package com.ssen.mongo.dao;

import com.ssen.mongo.entity.User;
import com.ssen.mongo.initialiser.MongoContainerInitialiserTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDatabaseTest extends MongoContainerInitialiserTest {

    @Autowired
    UserDao userDao;

    @Test
    void shouldSaveUserWhenProvidedWithDetails(){
        User user = new User("ss1","Soham","Sen","soham@abc.com");
        User insertedUser = userDao.saveUser(user);
        assert(insertedUser.getUserId().equalsIgnoreCase(user.getUserId()));
    }

    @Test
    void shouldGetNullWhenQueriedWithIdGivenUserIsNotPresent(){
        User queriedUser = userDao.getUser("ss");
        assert(null==queriedUser);
    }

    @Test
    void shouldGetUserWhenQueriedWithIdGivenUserIsPresent(){
        User user = new User("ss2","Soham","Sen","soham@yahoo.com");
        userDao.saveUser(user);
        User queriedUser = userDao.getUser("ss2");
        assert(queriedUser.getFirstName().equalsIgnoreCase("Soham"));
        assert(queriedUser.getLastName().equalsIgnoreCase("Sen"));
    }

    @Test
    void shouldUpdateUserWhenEmailIsChangedGivenUserIsPresent(){
        User existingUser = new User("ss3","Soham","Sen","soham@abc.com");
        userDao.saveUser(existingUser);
        User updatedUser = new User("ss3","Soham","Sen","soham@xyz.com");
        int updatedCount = userDao.updateMail(updatedUser);
        assert(1==updatedCount);
    }

    @Test
    void shouldDeleteUserWhenUserDetailsAreProvidedGivenUserIsPresent(){
        User user = new User("ss4","Soham","Sen","soham@abc.com");
        userDao.saveUser(user);
        int deletedCount = userDao.delete(user);
        assert(1==deletedCount);
    }
}
