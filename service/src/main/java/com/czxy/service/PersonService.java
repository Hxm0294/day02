package com.czxy.service;

import com.czxy.dao.PersonMapper;
import com.czxy.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/20 15:50
 */
@Service
@Transactional
public class PersonService {
    @Resource
    private PersonMapper personMapper;

    /**
     * 根据phone查询person
     * @param phone 手机号
     * @return person
     */
    public Person findPhone(String phone) {
        return personMapper.findPhone(phone);
    }

    /**
     * 添加
     * @param person 用户信息
     */
    public void add(Person person) {
        personMapper.insert(person);
    }

    public List<Person> findAll(){
        return personMapper.selectAll();
    }

    public List<Person> findByNameAndAddress(String username, String address){
        return personMapper.findByNameAndAddress(username,address);
    }
}
