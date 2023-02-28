package com.ssen.mongo.dao;

import com.ssen.mongo.entity.User;

public interface UserDao {

     User getUser(String userId);

     User saveUser(User user);

     int updateMail(User user);

     int delete(User user);
}
