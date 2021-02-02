package com.kimoro.domain;

import java.util.List;

/**
 * @ClassName QueryVo
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/19 16:19
 **/
public class QueryVo {
    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
