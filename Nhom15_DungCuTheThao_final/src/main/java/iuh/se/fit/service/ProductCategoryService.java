package iuh.se.fit.service;


import java.util.List;

import iuh.se.fit.model.ProductCategoryDTO;

public interface ProductCategoryService {

    public List<ProductCategoryDTO> findAll();
}
