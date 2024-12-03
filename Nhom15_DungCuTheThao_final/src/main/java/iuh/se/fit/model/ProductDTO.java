/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;

import java.util.List;


public class ProductDTO {

    private long productId;

    private String productName;

    private double price;

    private int productQuantity;

    private String image;

    private String description;

    private List<OrderDetailDTO> orderDetailDTO;

    private ProductCategoryDTO categoryDTO;

    private SaleDTO saleDTO;

    public ProductDTO() {
    }

    public ProductDTO(long productId, String productName, double price, int productQuantity, String image, String description, List<OrderDetailDTO> orderDetailDTO, ProductCategoryDTO categoryDTO, SaleDTO saleDTO) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productQuantity = productQuantity;
        this.image = image;
        this.description = description;
        this.orderDetailDTO = orderDetailDTO;
        this.categoryDTO = categoryDTO;
        this.saleDTO = saleDTO;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderDetailDTO> getOrderDetailDTO() {
        return orderDetailDTO;
    }

    public void setOrderDetailDTO(List<OrderDetailDTO> orderDetailDTO) {
        this.orderDetailDTO = orderDetailDTO;
    }

    public ProductCategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(ProductCategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public SaleDTO getSaleDTO() {
        return saleDTO;
    }

    public void setSaleDTO(SaleDTO saleDTO) {
        this.saleDTO = saleDTO;
    }

    
}
