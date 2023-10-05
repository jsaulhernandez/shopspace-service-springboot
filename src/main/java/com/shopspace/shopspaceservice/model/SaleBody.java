package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ss_sale_body")
public class SaleBody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private ViewProduct product;
    @Column(nullable = false)
    private Integer quantity;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "sale_header_id", nullable = false)
    private Long saleHeaderId;

    public SaleBody() {
    }

    public SaleBody(Long id, ViewProduct product, Integer quantity, BigDecimal price, Long saleHeaderId) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.saleHeaderId = saleHeaderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ViewProduct getProduct() {
        return product;
    }

    public void setProduct(ViewProduct product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getSaleHeaderId() {
        return saleHeaderId;
    }

    public void setSaleHeaderId(Long saleHeaderId) {
        this.saleHeaderId = saleHeaderId;
    }

    @Override
    public String toString() {
        return "SaleBody{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", saleHeaderId=" + saleHeaderId +
                '}';
    }
}
