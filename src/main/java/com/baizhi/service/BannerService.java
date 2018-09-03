package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAll(int start, int row);

    public void addBanner(Banner banner);

    public void deleteBanner(int id);

    public void updateBanner(Banner banner);

    public int query();
}
