/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.entity;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String productName;

    @Column(name = "product_price")
    private double price;

    @Column(name = "product_quantity")
    private int productQuantity;

    @Lob
    @Column(name = "product_image")
    private Blob image;

    @Column(name = "product_description")
    @Type(type = "org.hibernate.type.StringNVarcharType")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    public Product() {
    }

    public Product(String productName, double price, int productQuantity, String description,
            ProductCategory category, Sale sale) {
        super();
        this.productName = productName;
        this.price = price;
        this.productQuantity = productQuantity;
        this.description = description;
        this.category = category;
        this.sale = sale;
    }

    public Product(long productId, String productName, double price, int productQuantity, Blob image, String description, List<OrderDetail> orderDetails, ProductCategory category, Sale sale) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productQuantity = productQuantity;
        this.image = image;
        this.description = description;
        this.orderDetails = orderDetails;
        this.category = category;
        this.sale = sale;
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

}
