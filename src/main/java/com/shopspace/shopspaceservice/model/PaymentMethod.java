package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ss_payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer status;
    @Column(nullable = false)
    private Integer isCreditDebitCard;

    public PaymentMethod() {
    }

    public PaymentMethod(Long id, String name, Integer status, Integer isCreditDebitCard) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.isCreditDebitCard = isCreditDebitCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsCreditDebitCard() {
        return isCreditDebitCard;
    }

    public void setIsCreditDebitCard(Integer isCreditDebitCard) {
        this.isCreditDebitCard = isCreditDebitCard;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", isCreditDebitCard=" + isCreditDebitCard +
                '}';
    }
}
