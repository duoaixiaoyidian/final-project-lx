package com.baizhi.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/poi")
public class PoiController {
    @RequestMapping("/updown")
    public void testExport(HttpServletResponse response) {
        //创建工作簿对象
        HSSFWorkbook workbook = new HSSFWorkbook();

    }
}
