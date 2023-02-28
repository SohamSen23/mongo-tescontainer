package com.ssen.mongo.dao.impl;

import com.ssen.mongo.dao.UserDao;
import com.ssen.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Class<User> ENTITY= User.class;
    private static final String COLLECTION= "User";

    @Override
    public User getUser(String userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query,ENTITY,COLLECTION);
    }

    @Override
    public User saveUser(User user) {
        User insertedUser = mongoTemplate.insert(user,COLLECTION);
        return insertedUser;
    }

    @Override
    public int updateMail(User updatedUser) {
        String newMail = updatedUser.getEmail();
        Query query = new Query().addCriteria(Criteria.where("userId").is(updatedUser.getUserId()));
        Update update = new Update();
        update.set("email",newMail);
        return (int)mongoTemplate.updateFirst(query,update,ENTITY,COLLECTION).getModifiedCount();
    }

    @Override
    public int delete(User user) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(user.getUserId()));
        return (int)mongoTemplate.remove(query,ENTITY,COLLECTION).getDeletedCount();
    }
}
