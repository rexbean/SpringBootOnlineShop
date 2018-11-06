package com.rex.onlineShopSpringBoot.dao;

import com.rex.onlineShopSpringBoot.entity.Area;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AreaDao {
    /**
     * list the area list
     * @return area list
     */
    List<Area> queryArea();
}
