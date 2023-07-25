package com.example.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
/*@MapperScan(value = "com.example.demo.mapper" // mapper 인터페이스 경로 (경로를 반드시 잘 확인해주세요!)
        ,annotationClass = Mapper.class // 스캔할 어노테이션 이름
        ,sqlSessionFactoryRef = "sqlSessionFactory") // sqlSessionFactory Bean 이름

public class DataConfig {
    //@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:sql/*.xml")); // sql XML 위치
        return sqlSessionFactoryBean.getObject();
    }
}
*/
