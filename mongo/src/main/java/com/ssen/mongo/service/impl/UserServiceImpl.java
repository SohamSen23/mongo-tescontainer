package com.ssen.mongo.service.impl;

import com.ssen.mongo.dao.UserDao;
import com.ssen.mongo.entity.User;
import com.ssen.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int updateMail(User user) {
        return userDao.updateMail(user);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }
}
