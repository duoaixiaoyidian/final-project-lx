package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDAO {
    public List<Album> query();

    public void add(Album album);

    public void delete(int id);

    public Album queryOne(int id);
}
