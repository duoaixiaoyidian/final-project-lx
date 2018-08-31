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
import java.util.List;
import java.util.UUID;

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
    public String add(Banner banner, HttpServletRequest request, MultipartFile imgPath) {
        String realPath = request.getServletContext().getRealPath("/");
        String uploadPath = realPath + "upload";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String originalFilename = imgPath.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = s + "." + extension;
        try {
            imgPath.transferTo(new File(uploadPath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
