package com.kimoro.factory;

import com.kimoro.domain.Account;
import com.kimoro.service.IAccountService;
import com.kimoro.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 15:20
 * 用于创建Service代理对象的工厂
 **/
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     *
     * @return
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 添加事务的支持
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //1.开启事务
                    transactionManager.beginTransaction();
                    //2.执行操作
                    rtValue = method.invoke(accountService, args);
                    //3.提交事务
                    transactionManager.commit();
                    //4.返回结果
                    return rtValue;
                } catch (Exception e) {
                    //5.回滚操作
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //6.释放资源
                    transactionManager.release();
                }
            }
        });
    }
}
