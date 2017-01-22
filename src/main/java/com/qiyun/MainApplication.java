package com.qiyun;

import com.alibaba.druid.pool.DruidDataSource;
import com.qiyun.action.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }



//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new AccessTokenFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("accessToken");
//        registration.setOrder(1);
//        return registration;
//    }




    @Bean("dataSource")
    public DataSource getDruidDataSource(Environment env){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(env.getProperty("ds.driver"));
        druidDataSource.setUrl(env.getProperty("ds.dbUrl"));
        druidDataSource.setUsername(env.getProperty("ds.dbUserName"));
        druidDataSource.setPassword(env.getProperty("ds.dbPassowrd"));
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxActive(10);
        return druidDataSource;
    }
}
