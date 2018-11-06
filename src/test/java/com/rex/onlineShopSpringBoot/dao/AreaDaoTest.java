package com.rex.onlineShopSpringBoot.dao;

import com.rex.onlineShopSpringBoot.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        if(areaDao == null){
            System.out.println("it is null here");
        }
        List<Area> areaList = areaDao.queryArea();
        if(areaList == null){
            System.out.println("it is null here2");
        }
        assertEquals(2, areaList.size());
    }
}
