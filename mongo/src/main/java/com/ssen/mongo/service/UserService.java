package com.ssen.mongo.service;

import com.ssen.mongo.entity.User;

public interface UserService {

    User getUser(String userId);

    User saveUser(User user);

    int updateMail(User user);

    int delete(User user);
}
