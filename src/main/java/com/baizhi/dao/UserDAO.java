package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserBo;
import com.baizhi.entity.UserDto;

import java.util.List;

public interface UserDAO {
    public List<User> query();

    public int queryCount(Integer day);
    public void update(User user);

    public void updateById(int id);

    public List<UserDto> queryBySex(String sex);

    public void add(String phoneNum, String password);

    public List<UserBo> queryByBo(String phoneNum);

}
