/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.fit.dao.ProductCategoryDao;
import iuh.se.fit.entity.ProductCategory;
import iuh.se.fit.model.ProductCategoryDTO;
import iuh.se.fit.service.ProductCategoryService;


@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    private ProductCategoryDao categoryDao;
    
    @Override
    public List<ProductCategoryDTO> findAll() {
        List<ProductCategory> categories = categoryDao.findAll();
        List<ProductCategoryDTO> categoryDTOs = new ArrayList<ProductCategoryDTO>();
        for (ProductCategory category : categories) {
            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTOs.add(categoryDTO);
        }
        return categoryDTOs;
    }
    
}
