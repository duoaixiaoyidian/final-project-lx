package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<User> showAll() {
        List<User> users = userService.queryAll();
        return users;
    }

    @RequestMapping("/update")
    public String update(User user) {
        userService.updateUser(user);
        return "main/main";
    }

    @RequestMapping("/down")
    public void down(String name, String excelPath, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getServletContext().getRealPath("/");
        String filePath = realPath + "upload/" + excelPath;
        File file = new File(filePath);
        String extension = FilenameUtils.getExtension(excelPath);
        name = name + "." + extension;
        String a = null;
        try {
            a = new String(name.getBytes("utf-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + a);
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/export")
    public void export() {
        //创建工作簿对象
        Workbook workbook = new HSSFWorkbook();
        //创建sheet
        Sheet sheet = workbook.createSheet("user");
        //创建行
        Row row = sheet.createRow(0);
        //修改日期样式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        //创建单元格样式
        CellStyle style = workbook.createCellStyle();
        //居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //修改字体
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setBold(true);
        style.setFont(font);
        //创建标题行
        String[] strs = {"编号", "头像", "名称", "法名", "性别", "省份", "城市", "签名", "电话", "密码", "私盐", "状态", "注册日期", "上师ID"};
        for (int i = 0; i < strs.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(strs[i]);
        }
        //创建数据行  查询数据库

        List<User> users = userService.queryAll();
     /*   for (int i = 1; i <users.size()+1 ; i++) {
            Row row1 = sheet.createRow(i + 1);
            String methodName="get"+users.get(i).
            int cellType = row1.createCell(i).getCellType();
            if (cellType==Cell.CELL_TYPE_STRING) {
                row1.createCell(i).setCellValue();
            }

        }*/


    }

    @RequestMapping("/import")
    public void importExcel() throws Exception {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("f:/project/user.xls"));
        Sheet sheet = workbook.createSheet("user");
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        List<String> titles = new ArrayList<String>();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            titles.add(field.getName());
        }
        List<User> users = new ArrayList<User>();
        User user1 = new User();
        Class<? extends User> aClass1 = user1.getClass();
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            User user2 = new User();
            for (int j = 0; j < titles.size(); j++) {
                int cellType = row.getCell(j).getCellType();
                String methodName = "set" + titles.get(j).substring(0, 1).toUpperCase() + titles.get(j).substring(1);
                if (cellType == Cell.CELL_TYPE_STRING) {
                    String stringCellValue = row.getCell(j).getStringCellValue();
                    setParamter(aClass, methodName, user2, stringCellValue, String.class);
                } else if (cellType == CELL_TYPE_NUMERIC) {
                    Number numericCellValue = row.getCell(j).getNumericCellValue();
                    setParamter(aClass, methodName, user2, numericCellValue, Number.class);
                } else {
                    Date dateCellValue = row.getCell(j).getDateCellValue();
                    setParamter(aClass, methodName, user2, dateCellValue, Date.class);
                }
            }
            users.add(user2);
        }

    }

    public static void setParamter(Class<? extends User> aClass, String methodName, Object object, Object args, Class<?>... parameterTypes) {
        Method method = null;
        try {
            method = aClass.getMethod(methodName, parameterTypes);
            method.invoke(object, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/customerExport")
    public void customerExport(String titles, String params, HttpServletResponse response) {

        Workbook workbook = new HSSFWorkbook();
        //日期样式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        /*创建单元格样式*/
        CellStyle cellStyle1 = workbook.createCellStyle();
        /*居中*/
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        /*修改字体*/
        Font font = workbook.createFont();
        font.setFontName("楷体");
        font.setBold(true);
        cellStyle.setFont(font);
        /*标题行*/
        Sheet sheet = workbook.createSheet("user");
        Row row = sheet.createRow(0);
        String[] strs = titles.split(",");
        for (int i = 0; i < strs.length; i++) {
            row.createCell(i).setCellValue(strs[i]);
        }
        /*数据行*/
        String[] fields = params.split(",");
        List<User> users = userService.queryAll();
        for (int i = 0; i < users.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            User user = users.get(i);
            /*获取类对象*/
            Class<? extends User> userClass = user.getClass();
            for (int j = 0; j < fields.length; j++) {
                Cell cell = row1.createCell(j);
                /*获得方法名*/
                String methodName = "get" + fields[j].substring(0, 1).toUpperCase() + fields[j].substring(1);
                /*获取调用的方法对象*/
                try {
                    Method method = userClass.getMethod(methodName, null);
                    Object invoke = method.invoke(user, null);
                    if (invoke instanceof Date) {
                        sheet.setColumnWidth(j, 21 * 256);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    } else if (invoke instanceof String) {
                        cell.setCellValue((String) invoke);
                    } else {
                        cell.setCellValue((int) invoke);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                /*创建单元格并且填充内容*/
            }
        }
        String a = new Date().getTime() + "userExcel.xls";
        String newName = null;
        try {
            newName = new String(a.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;filename=" + newName);
        response.setContentType("application/vnd.ms-excel");

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
