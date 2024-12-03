/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;

import java.util.List;


public class ProductCategoryDTO {

    private long categoryId;

    private String categoryName;
    
    private List<ProductDTO> productDTOs;

    public ProductCategoryDTO() {
    }

    public ProductCategoryDTO(long categoryId, String categoryName, List<ProductDTO> productDTOs) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productDTOs = productDTOs;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductDTO> getProductDTOs() {
        return productDTOs;
    }

    public void setProductDTOs(List<ProductDTO> productDTOs) {
        this.productDTOs = productDTOs;
    }

   
}
