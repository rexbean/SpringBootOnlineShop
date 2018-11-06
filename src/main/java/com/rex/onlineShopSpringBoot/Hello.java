package com.rex.onlineShopSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Response + @Controller
public class Hello {
    @RequestMapping(name = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello SpringBoot!";
    }
}
