package com.rex.onlineShopSpringBoot.service.impl;

import com.rex.onlineShopSpringBoot.dao.AreaDao;
import com.rex.onlineShopSpringBoot.entity.Area;
import com.rex.onlineShopSpringBoot.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
