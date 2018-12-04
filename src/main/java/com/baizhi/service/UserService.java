package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.entity.UserBo;
import com.baizhi.entity.UserDto;

import java.util.List;

public interface UserService {
    public void updateUser(User user);

    public void updateUserById(int id);

    public int queryNum(Integer day);
    public List<User> queryAll();

    public List<UserDto> queryBySex(String sex);

    public void add(String phoneNum, String password);

    public List<UserBo> queryByBo(String phoneNum);
}
