package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by M on 2018/8/28.
 */
public interface AdminDAO {
    public void save(Admin admin);

    public Admin queryAdmin(@Param("username") String username, @Param("password") String password);

    public void deleteAdmin(Admin admin);
}
