package com.baizhi.document;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginInterface {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Object login(String phone, String password) {
        Map<String, String> map = new HashMap<String, String>();
        List<User> users = null;
        try {
            users = userService.queryAll();
        } catch (Exception e) {
            map.put("error", "账号或密码有误");
            e.printStackTrace();
            return map;
        }

        return users;
    }
}
