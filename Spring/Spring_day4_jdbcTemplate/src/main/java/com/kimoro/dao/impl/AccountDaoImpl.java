package com.kimoro.dao.impl;

import com.kimoro.dao.IAccountDao;
import com.kimoro.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @ClassName AccountDaoImpl
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/27 10:31
 **/
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accounts.isEmpty()) {
            return null;
        } else if (accounts.size() > 1) {
            throw new RuntimeException("结果集不止一个");
        } else {
            return accounts.get(0);
        }
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
