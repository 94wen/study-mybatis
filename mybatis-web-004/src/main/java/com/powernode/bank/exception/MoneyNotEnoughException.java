package com.powernode.bank.exception;

/**
 * @Author wen
 * @Data 2023/6/5 10:46
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
