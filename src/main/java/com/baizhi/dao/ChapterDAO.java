package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDAO {
    public void add(Chapter chapter);

    public void delete(int uuid);

    public List<Chapter> queryAll();
}
