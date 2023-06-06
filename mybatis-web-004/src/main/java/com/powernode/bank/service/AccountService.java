package com.powernode.bank.service;

import com.powernode.bank.exception.MoneyNotEnoughException;
import com.powernode.bank.exception.TransferException;

/**
 * @Author wen
 * @Data 2023/6/4 16:54
 */
public interface AccountService {
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
