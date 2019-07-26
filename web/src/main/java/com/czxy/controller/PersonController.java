package com.czxy.controller;

import com.czxy.domain.Category;
import com.czxy.domain.Person;
import com.czxy.service.CategoryService;
import com.czxy.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hxm
 * @version v 1.0
 * @date 2019/7/20 15:53
 */
@RestController
@RequestMapping("person")
public class PersonController {
    @Resource
    private CategoryService categoryService;

    @Resource
    private PersonService personService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findCategoryAll() {
        try {
            List<Category> categories = categoryService.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Person> add(Person person) {
        //根据手机号 查询 数据库里有没有这个信息
        Person phone = personService.findPhone(person.getPhone());

        if(phone == null){
            //phone 为 null  就代表数据库中没有这个用户
            //调用 service 方法 把这个数据 添加到数据库
            personService.add(person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            //不为null 则 代表 数据库中有 不能添加 把person 传到 浏览器
             return new ResponseEntity<>(person,HttpStatus.OK);
        }
    }

    @GetMapping("/findPersonAll")
    public ResponseEntity<List<Person>> findPersonAll(){
        try {
            List<Person> personList = personService.findAll();
            return new ResponseEntity<>(personList,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findByNameAndAddress")
    public ResponseEntity<List<Person>> findByNameAndAddress(Person person){
        String username = null;
        String address = null;
        if("".equals(person.getUsername()) ){
            username = person.getUsername();
        }else {
            username = "%"+person.getUsername()+"%";

        }
        if("".equals(person.getAddress())){
            address = person.getAddress();
        }else {
            address = "%"+person.getAddress()+"%";
        }


        try {
            List<Person> people = personService.findByNameAndAddress(username, address);
            if (people.size() == 0){
                people= personService.findAll();
            }
            return new ResponseEntity<>(people,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
