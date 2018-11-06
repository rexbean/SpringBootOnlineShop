package com.rex.onlineShopSpringBoot.service;

import com.rex.onlineShopSpringBoot.dto.ShopExecution;
import com.rex.onlineShopSpringBoot.entity.Area;
import com.rex.onlineShopSpringBoot.entity.Shop;
import com.rex.onlineShopSpringBoot.entity.ShopCategory;
import com.rex.onlineShopSpringBoot.entity.UserInfo;
import com.rex.onlineShopSpringBoot.enums.ShopStateEnum;
import com.rex.onlineShopSpringBoot.exceptions.ShopOperationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest{
    @Autowired
    private ShopService shopService;

    @Test
    public void testModifyShop() throws ShopOperationException, FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopName("after modified");
        shop.setShopId(1L);
        File shopImg = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Jellyfish.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.modifyShop(shop, is, "Jellyfish.jpg");
        System.out.println("new image address " + se.getShop().getShopImg());
    }
    @Test
    public void testAddShop(){
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
        shop.setShopName("TestShop2");
        shop.setShopDesc("TestDesc2");
        shop.setShopAddr("Santa Clara");
        shop.setAdvice("checking");
        shop.setPhone("123123");
        shop.setShopImg("01");
        shop.setCreatedTime(new Date());
        shop.setStatus(ShopStateEnum.CHECK.getState());


        File shopImg = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
        try {
            InputStream ins = new FileInputStream(shopImg);
            ShopExecution se = shopService.addShop(shop, ins, shopImg.getName());
            assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
