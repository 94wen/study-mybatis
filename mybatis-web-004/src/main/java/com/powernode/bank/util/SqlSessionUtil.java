package com.powernode.bank.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author wen
 * @Data 2023/5/23 23:09
 * mybatis工具类
 */
public class SqlSessionUtil {
    //工具类的构造方法一般私有化
    //工具类所有方法都是静态的，直接采用类名即可调用，不需要new对象
    //防止new对象，构造方法私有化
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if (sqlSession !=null) {
            sqlSession.close();
            local.remove();
        }
    }
}
