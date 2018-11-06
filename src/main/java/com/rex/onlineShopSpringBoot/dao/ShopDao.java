package com.rex.onlineShopSpringBoot.dao;

import com.rex.onlineShopSpringBoot.entity.Shop;
import org.springframework.stereotype.Component;

@Component
public interface ShopDao {
    /**
     * Add new shop
     * @param shop shop
     * @return status
     */
    int insertShop(Shop shop);

    /**
     * update the shop info
     * @param shop shop
     * @return result
     */
    int updateShop(Shop shop);

    Shop queryByShopId(long shopId);
}
