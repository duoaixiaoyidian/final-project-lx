package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by M on 2018/8/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/add")
    public String addAdmin(Admin admin) {
        adminService.addAdmin(admin);
        return "/main/main";
    }

    @RequestMapping("/login")
    public String login(String name, String password, Admin admin) {
        if (admin.getName().equals(name) & admin.getPassword().equals(password)) {
            Admin ad = adminService.queryAdmin(name, password);
            return "/main/main";
        } else {
            return "/login";
        }
    }

    @RequestMapping("/delete")
    public String delete(Admin admin) {
        adminService.deleteAdmin(admin);
        return "/main/main";
    }
}
