package com.rex.onlineShopSpringBoot.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.rex.onlineShopSpringBoot.util.DESUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
@MapperScan("com.rex.onlineShopSpringBoot.dao")
public class DataSourceConfiguration {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.master.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    /**
     * spring-dao.xml
     *
     **/
    @Bean(name = "myDataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        // generate a data source
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // configuration
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(DESUtil.getDecryptString(username));
        dataSource.setPassword(DESUtil.getDecryptString(password));

        dataSource.setMaxPoolSize(30);
        dataSource.setMinPoolSize(10);
        dataSource.setAutoCommitOnClose(false);
        dataSource.setAcquireRetryAttempts(2);

        return dataSource;
    }

}
