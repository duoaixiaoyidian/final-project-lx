package com.baizhi.document;

import com.baizhi.entity.UserBo;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/regist")
public class RegistInterface {
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    public Object register(String phoneNum, String password) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            userService.add(phoneNum, password);
            List<UserBo> userBos = userService.queryByBo(phoneNum);
            for (UserBo userBo : userBos) {
                map.put("phoneNum", userBo.getPhoneNum());
                map.put("password", userBo.getPassword());
                map.put("uid", userBo.getUid() + "");

            }
            return map;
        } catch (Exception e) {
            map.put("error", "该手机号已注册");
            e.printStackTrace();
            return map;
        }

    }
}
