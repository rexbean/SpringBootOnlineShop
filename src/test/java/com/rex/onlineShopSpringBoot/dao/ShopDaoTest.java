package com.rex.onlineShopSpringBoot.dao;

import com.rex.onlineShopSpringBoot.entity.Area;
import com.rex.onlineShopSpringBoot.entity.Shop;
import com.rex.onlineShopSpringBoot.entity.ShopCategory;
import com.rex.onlineShopSpringBoot.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest

public class ShopDaoTest{
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        UserInfo owner = new UserInfo();
        Area area = new Area();
        ShopCategory sc = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        sc.setShopCatagoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(sc);
        shop.setShopName("TestShop");
        shop.setShopDesc("TestDesc");
        shop.setShopAddr("San Jose");
        shop.setAdvice("checking");
        shop.setPhone("123123");
        shop.setShopImg("01");
        shop.setCreatedTime(new Date());
        shop.setStatus(1);
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(3L);
        shop.setShopDesc("Describe");
        shop.setAdvice("checking");
        shop.setCreatedTime(new Date());
        shop.setModifiedTime(new Date());
        shop.setStatus(0);
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
    @Test
    public void testQueryByShopId(){
        long shopId = 3L;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId = " + shop.getArea().getAreaId());
        System.out.println("shopId =" + shop.getShopId());
        System.out.println("CreatedTime = " + shop.getCreatedTime());
    }


}
