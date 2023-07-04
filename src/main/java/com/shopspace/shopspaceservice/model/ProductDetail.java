package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ss_product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier;
    private String value;
    @Column(name = "product_id")
    private Long productId;

    public ProductDetail() {
    }

    public ProductDetail(Long id, String identifier, String value, Long productId) {
        this.id = id;
        this.identifier = identifier;
        this.value = value;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", value='" + value + '\'' +
                ", productId=" + productId +
                '}';
    }
}
