package com.wen.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Author wen
 * @Data 2023/5/22 16:21
 */
public class MyBatisTest {
    public static void main(String[] args) throws Exception{
        //获取SqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql语句
        int count = sqlSession.insert("insertcar");
        System.out.println("插入了几条记录："+count);

        //手动提交
        sqlSession.commit();
    }
}
