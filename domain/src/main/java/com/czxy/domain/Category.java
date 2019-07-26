package com.czxy.domain;

import javax.persistence.Id;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/20 15:41
 */

public class Category {
    @Id
    private Integer cid;
    private String cname;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public String getCname() {

        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Category() {
    }
}
