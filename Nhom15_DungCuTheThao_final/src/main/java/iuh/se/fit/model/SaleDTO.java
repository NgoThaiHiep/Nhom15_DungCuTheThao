/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;

import java.util.List;


public class SaleDTO {

    private long saleId;
    
    private int percent;
    
    private List<ProductDTO> productDTOs;

    public SaleDTO() {
    }

    public SaleDTO(long saleId, int percent, List<ProductDTO> productDTOs) {
        this.saleId = saleId;
        this.percent = percent;
        this.productDTOs = productDTOs;
    }

    public long getSaleId() {
        return saleId;
    }

    public void setSaleId(long saleId) {
        this.saleId = saleId;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public List<ProductDTO> getProductDTOs() {
        return productDTOs;
    }

    public void setProductDTOs(List<ProductDTO> productDTOs) {
        this.productDTOs = productDTOs;
    }

    
}
