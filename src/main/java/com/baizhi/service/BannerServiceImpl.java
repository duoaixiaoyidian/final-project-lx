package com.baizhi.service;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDAO bannerDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Banner> queryAll() {
        return bannerDAO.queryAll();
    }

    @Override
    public void addBanner(Banner banner) {
        bannerDAO.add(banner);
    }

    @Override
    public void deleteBanner(int id) {
        bannerDAO.delete(id);
    }

    @Override
    public void updateBanner(Banner banner) {
        bannerDAO.update(banner);
    }
}
