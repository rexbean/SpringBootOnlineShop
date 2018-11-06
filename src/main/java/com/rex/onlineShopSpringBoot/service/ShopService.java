package com.rex.onlineShopSpringBoot.service;

import com.rex.onlineShopSpringBoot.dto.ShopExecution;
import com.rex.onlineShopSpringBoot.entity.Shop;
import com.rex.onlineShopSpringBoot.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String Filename);

    Shop getShopById(long shopId);

    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String filename) throws ShopOperationException;
}
