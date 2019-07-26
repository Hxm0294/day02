package com.czxy.service;

import com.czxy.dao.CategoryMapper;
import com.czxy.domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 11111
 * @version v 1.0
 * @date 2019/7/20 15:47
 */
@Service
@Transactional
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;


    public List<Category> findAll(){
        return categoryMapper.selectAll();
    }
}
