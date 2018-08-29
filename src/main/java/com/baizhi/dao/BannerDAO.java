package com.baizhi.dao;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerDAO {
    public List<Banner> queryAll();

    public void add(Banner banner);

    public void delete(int id);

    public void update(Banner banner);
}
