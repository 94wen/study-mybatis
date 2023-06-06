package com.powernode.mybatis.text;

import com.powernode.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author wen
 * @Data 2023/5/23 23:29
 */
public class CarMapperTest {

    @Test
    public void testSqlUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertcar");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }
}
