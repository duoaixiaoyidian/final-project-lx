package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by M on 2018/8/28.
 */
public interface AdminService {
    public void addAdmin(Admin admin);

    public Admin queryAdmin(String username, String password);

    public void deleteAdmin(Admin admin);
}
