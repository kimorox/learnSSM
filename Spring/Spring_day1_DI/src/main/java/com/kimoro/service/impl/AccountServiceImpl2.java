package com.kimoro.service.impl;

import com.kimoro.service.IAccountService;

import java.util.Date;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/23 16:43
 * 账户的业务层实现类
 **/
public class AccountServiceImpl2 implements IAccountService {
    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("----------accountService中的saveAccount执行了----------");
        System.out.println(name + " " + age + " " + birthday);
    }

}
