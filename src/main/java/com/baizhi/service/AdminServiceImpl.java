package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by M on 2018/8/28.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public void addAdmin(Admin admin) {
        adminDAO.save(admin);
    }

    @Override
    public Admin queryAdmin(String username, String password) {
        return adminDAO.queryAdmin(username, password);
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDAO.deleteAdmin(admin);
    }
}
