package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Banner> showAll() {
        List<Banner> banners = bannerService.queryAll();
        return banners;
    }

    @RequestMapping("/add")
    public String add(Banner banner) {
        bannerService.addBanner(banner);
        return "/main/main";
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        bannerService.deleteBanner(id);
        return "/main/main";
    }

    @RequestMapping("/update")
    public String update(Banner banner) {
        bannerService.updateBanner(banner);
        return "/main/main";
    }
}
