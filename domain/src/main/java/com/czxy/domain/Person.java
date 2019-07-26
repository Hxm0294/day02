package com.czxy.domain;

import javax.persistence.Id;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/20 15:42
 */
public class Person {
    @Id
    private Integer pid;
    private String username;
    private String  category;
    private String address;
    private String phone;
    private String  postcode;


    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", category='" + category + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Person() {
    }
}
