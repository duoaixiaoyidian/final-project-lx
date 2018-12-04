package com.baizhi.service;

import com.baizhi.Aspect.LogAnnotation;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.entity.UserBo;
import com.baizhi.entity.UserDto;
import com.baizhi.util.RandomSaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @LogAnnotation(name = "修改")
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void updateUserById(int id) {
        userDAO.updateById(id);
    }

    @Override
    public int queryNum(Integer day) {
        return userDAO.queryCount(day);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> queryAll() {
        //return userDAO.query();
        throw new RuntimeException();
    }

    @Override
    public List<UserDto> queryBySex(String sex) {
        return userDAO.queryBySex(sex);
    }

    @Override
    public void add(String phoneNum, String password) {
        //生成私盐并设置到user对象
        String salt = RandomSaltUtil.generetRandomSaltCode();
//用户输入的密码拼接我们的私盐然后加密，设置到user对象
        String password1 = DigestUtils.md5Hex(salt + password);

        userDAO.add(phoneNum, password1);
    }

    @Override
    public List<UserBo> queryByBo(String phoneNum) {
        return userDAO.queryByBo(phoneNum);
    }
}
