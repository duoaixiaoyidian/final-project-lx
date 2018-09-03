package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/all")
    @ResponseBody
    public Map<String, Object> showAll(int page, int rows) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Banner> banners = bannerService.queryAll(page, rows);
        int total = bannerService.query();
        map.put("total", total);
        map.put("rows", banners);
        return map;
    }


    @RequestMapping("/add")
    public String add(Banner banner, HttpServletRequest request, MultipartFile imgs) {
        String realPath = request.getServletContext().getRealPath("/");
        String uploadPath = realPath + "upload";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String originalFilename = imgs.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = s + "." + extension;
        try {
            imgs.transferTo(new File(uploadPath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setImgPath("/upload/" + newName);
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
