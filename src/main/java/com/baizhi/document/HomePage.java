package com.baizhi.document;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.Menu;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/document")
public class HomePage {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/firstPage")
    public Map<String, Object> queryAll(Integer uid, String type) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Menu> query1 = menuService.query();
        List<Album> query2 = albumService.queryAll();
        List<Chapter> query3 = chapterService.queryAll();
        if ("all".equals(type)) {
            map.put("all", query1);
            return map;
        } else if ("wen".equals(type)) {
            map.put("wen", query2);
            return map;
        } else {
            map.put("si", query3);
            return map;
        }

    }
}
