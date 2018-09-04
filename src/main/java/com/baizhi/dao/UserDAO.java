package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> query();

    public void update(User user);
}
