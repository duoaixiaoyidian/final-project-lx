package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<Chapter> showAll() {
        List<Chapter> chapters = chapterService.queryAll();
        return chapters;

    }

    @RequestMapping("/add")
    public String add(Chapter chapter) {
        chapterService.addChapter(chapter);
        return "main/main";
    }

    @RequestMapping("/delete")
    public String add(int id) {
        chapterService.deleteChapter(id);
        return "main/main";
    }
}
