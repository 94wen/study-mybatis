package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;
import com.powernode.bank.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author wen
 * @Data 2023/6/4 17:00
 */
public class AccountDaoImpl implements AccountDao{
    @Override
    public Account selectByActno(String arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return (Account) sqlSession.selectOne("account.selectByActno",arg0);
    }

    @Override
    public int updateByActno(Account arg0) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        return sqlSession.update("account.updateByActno",arg0);
    }
}
