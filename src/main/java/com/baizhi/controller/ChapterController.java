package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.Mp3Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

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
    public void add(Chapter chapter, HttpServletRequest request, MultipartFile path) {
        String realPath = request.getServletContext().getRealPath("/");
        String uploadPath = realPath + "audio";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String originalFilename = path.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(originalFilename);
        String newName = s + "." + extension;
        try {
            path.transferTo(new File(uploadPath, newName));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //获取时长
        File file1 = new File(uploadPath + "/" + newName);

        String duration = Mp3Util.getDuration(file1);
        chapter.setDuration(duration);

        System.out.println(duration);

        //设置章节的大小
        long size = path.getSize();
        String s1 = "";
        if (size > 1024 * 1024) {
            s1 = String.format("%.2f", (double) size / (1024 * 1024)) + "M";

        } else {
            s1 = String.format("%.2f", (double) size / (1024)) + "KB";
        }
        String id1 = UUID.randomUUID().toString();
        chapter.setId(id1);
        chapter.setSize(s1);
        chapter.setAudioPath(newName);
        chapterService.addChapter(chapter);

    }

    @RequestMapping("/delete")
    public String delete(String id) {
        chapterService.deleteChapter(id);
        return "main/main";
    }

    @RequestMapping("/down")
    public void down(String name, String audioPath, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath("/");
        String filePath = realPath + "audio/" + audioPath;
        File file = new File(filePath);
        String extension = FilenameUtils.getExtension(audioPath);
        name = name + "." + extension;
        String a = null;
        try {
            a = new String(name.getBytes("utf-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");
        response.setHeader("Content-Disposition", "attachment;filename=" + a);
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
