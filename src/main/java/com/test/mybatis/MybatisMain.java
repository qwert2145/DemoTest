package com.test.mybatis;

import com.test.mybatis.mapper.CountryMapper;
import com.test.mybatis.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MybatisMain {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFacory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /******************************分割线******************************/
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
//        Country country = new Country();
//        country.setCountrycode("1001");
//        country.setCountryname("中国");
//        mapper.insert(country);
        System.out.println(mapper.selectByPrimaryKey(7));
        sqlSession.commit();
        sqlSession.close();
    }
}
