package com.shopspace.shopspaceservice.model;

import com.shopspace.shopspaceservice.converter.DateConverter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ss_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String name;
    private String description;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private String model;
    private String modelNumber;
    @Convert(converter = DateConverter.class)
    private Date releaseDate;
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ViewProduct> viewProducts;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductDetail> productDetails;
    @ManyToOne()
    @JoinColumn(name = "type_classification_id")
    private TypeClassification typeClassification;
    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Product() {
    }

    public Product(Long id, String title, String name, String description, BigDecimal price, String model, String modelNumber, Date releaseDate, Integer status, List<ViewProduct> viewProducts, List<ProductDetail> productDetails, TypeClassification typeClassification, Brand brand) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.description = description;
        this.price = price;
        this.model = model;
        this.modelNumber = modelNumber;
        this.releaseDate = releaseDate;
        this.status = status;
        this.viewProducts = viewProducts;
        this.productDetails = productDetails;
        this.typeClassification = typeClassification;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ViewProduct> getViewProducts() {
        return viewProducts;
    }

    public void setViewProducts(List<ViewProduct> viewProducts) {
        this.viewProducts = viewProducts;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public TypeClassification getTypeClassification() {
        return typeClassification;
    }

    public void setTypeClassification(TypeClassification typeClassification) {
        this.typeClassification = typeClassification;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", releaseDate=" + releaseDate +
                ", status=" + status +
                ", viewProducts=" + viewProducts +
                ", productDetails=" + productDetails +
                ", typeClassification=" + typeClassification +
                ", brand=" + brand +
                '}';
    }
}
