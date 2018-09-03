package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDAO {
    public List<Banner> queryAll(@Param("start") int start, @Param("row") int row);

    public void add(Banner banner);

    public void delete(int id);

    public void update(Banner banner);

    public int query();

}
