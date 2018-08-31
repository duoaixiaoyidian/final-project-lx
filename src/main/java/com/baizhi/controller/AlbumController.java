package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<Album> showAll() {
        return albumService.queryAll();
    }

    @RequestMapping("/add")
    public String add(Album album) {
        albumService.addAlbum(album);
        return "main/main";
    }

    @RequestMapping("/delete")
    public String add(int id) {
        albumService.deleteAlbum(id);
        return "main/main";
    }

    @RequestMapping("/showOne")
    @ResponseBody
    public Album showOne(int id) {
        Album one = albumService.queryOne(id);
        return one;
    }
}
