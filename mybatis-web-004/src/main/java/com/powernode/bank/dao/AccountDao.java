package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * @Author wen
 * @Data 2023/6/4 16:57
 */
public interface AccountDao {
    //查询用户信息
    Account selectByActno(String actno);

    //更新用户信息
    int updateByActno(Account act);

}
