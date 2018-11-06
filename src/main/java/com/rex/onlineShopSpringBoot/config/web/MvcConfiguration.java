package com.rex.onlineShopSpringBoot.config.web;

import com.rex.onlineShopSpringBoot.Interceptor.shopAdmin.ShopLoginInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class MvcConfiguration implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationConext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationConext = applicationContext;
    }

    /**
     * static resource configuration
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    /**
     * create view resolver
     */
    @Bean(name = "viewResolver")
    public ViewResolver creat(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // set spring container
        viewResolver.setApplicationContext(this.applicationConext);
        // remove cache
        viewResolver.setCache(false);
        // set resolver prefix
        viewResolver.setPrefix("/WEB-INF/html/");
        // set view resolver suffix
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    /**
     * file upload resolver
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver create(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");

        //1024 *1024 *20 = 20M
        multipartResolver.setMaxUploadSize(20971520);
        multipartResolver.setMaxInMemorySize(20971520);
        return multipartResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // registry interceptor;
        String interceptPath = "/shopadmin/**";
        InterceptorRegistration loginIR = registry.addInterceptor(new ShopLoginInterceptor());
        loginIR.addPathPatterns(interceptPath);

        // interceptorRegistration. add PathPatterns("path")
        // interceptorRegistration.excludePathPatterns("exclude-path");
    }


}
