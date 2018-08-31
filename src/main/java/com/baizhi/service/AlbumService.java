package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    public void addAlbum(Album album);

    public void deleteAlbum(int id);

    public List<Album> queryAll();

    public Album queryOne(int id);
}
