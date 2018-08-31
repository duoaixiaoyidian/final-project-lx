package com.baizhi.service;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDAO albumDAO;

    @Override
    public void addAlbum(Album album) {
        albumDAO.add(album);
    }

    @Override
    public void deleteAlbum(int id) {
        albumDAO.delete(id);
    }

    @Override
    public List<Album> queryAll() {
        return albumDAO.query();
    }

    @Override
    public Album queryOne(int id) {
        return albumDAO.queryOne(id);
    }
}
