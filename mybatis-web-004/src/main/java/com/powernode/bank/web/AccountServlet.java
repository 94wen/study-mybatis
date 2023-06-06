package com.powernode.bank.web;


import com.powernode.bank.exception.MoneyNotEnoughException;
import com.powernode.bank.exception.TransferException;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.AccountServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.MalformedInputException;

/**
 * @Author wen
 * @Data 2023/6/4 16:45
 */
//@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws SecurityException, IOException{
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money =  Double.parseDouble(request.getParameter("money"));
        try {
            accountService.transfer(fromActno,toActno,money);
            response.sendRedirect(request.getContextPath()+"/success.html");
        }catch (MoneyNotEnoughException e){
            response.sendRedirect(request.getContextPath()+"/moneyerror1.html");
        }catch (TransferException e){
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }
    }
}
