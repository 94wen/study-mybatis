package com.powernode.bank.service;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.AccountDaoImpl;
import com.powernode.bank.exception.MoneyNotEnoughException;
import com.powernode.bank.exception.TransferException;
import com.powernode.bank.pojo.Account;

/**
 * @Author wen
 * @Data 2023/6/4 16:56
 */
public class AccountServiceImpl implements AccountService{

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
          //判断余额是否异常
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money) {
            throw new MoneyNotEnoughException("余额不足，无法转账");
        }
        //更新余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        int count = accountDao.updateByActno(fromAct);
        count += accountDao.updateByActno(toAct);
        if (count !=2) {
            throw new TransferException("异常");
        }

    }
}
