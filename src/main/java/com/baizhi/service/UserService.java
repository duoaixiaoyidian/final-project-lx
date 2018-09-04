package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    public void updateUser(User user);

    public List<User> queryAll();
}
