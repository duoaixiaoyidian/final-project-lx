package com.baizhi.controller;


import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    @RequestMapping("/createCaptcha.do")
    public void createCaptcha(HttpServletResponse response, HttpSession session) {
        //1.获取验证码随机数
        String securityCode = SecurityCode.getSecurityCode();
        session.setAttribute("serverCode", securityCode);
        //2.生成验证码图片
        BufferedImage image = SecurityImage.createImage(securityCode);
        try {
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
