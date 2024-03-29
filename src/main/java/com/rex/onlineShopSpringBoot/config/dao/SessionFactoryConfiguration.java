package com.rex.onlineShopSpringBoot.config.dao;

import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

@Configuration
public class SessionFactoryConfiguration {
    @Autowired
    private DataSource myDataSource;
    private static String mybatisConfigFile;
    private static String mapperPath;

    @Value("${mybatis_config_file}")
    public void setMybatisConfigFile(String mybatisConfigFile) {
        SessionFactoryConfiguration.mybatisConfigFile = mybatisConfigFile;
    }

    @Value("${mapper_path}")
    public void setMapperPath(String mapperPath) {
        SessionFactoryConfiguration.mapperPath = mapperPath;
    }

    @Value("${type_alias_package}")
    private String typeAliasPackage;

    @Bean(name = "${sqlSessionFactory}")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFile));
        // set mapper path
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver
                = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver
                .getResources(packageSearchPath));

        sqlSessionFactoryBean.setDataSource(myDataSource);
        // set typeAlias package path
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactoryBean;
    }
}
