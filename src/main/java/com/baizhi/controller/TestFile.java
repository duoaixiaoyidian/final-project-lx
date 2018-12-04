package com.baizhi.controller;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TestFile {
    @Test
    public void test1() throws IOException {
        File f = new File("D:\\project");
        printJavaFiles(f);


    }

    static void printJavaFiles(File dir) {
        File[] fs = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) return true;
                if (f.isFile()) {
                    String name = f.getName();
                    if (name.endsWith(".java")) return true;
                    else return false;
                } else return false;
            }

        });
        for (File f : fs
                ) {
            if (f.isFile()) System.out.println(f.getAbsolutePath());
            else printJavaFiles(f);
        }
    }
}
