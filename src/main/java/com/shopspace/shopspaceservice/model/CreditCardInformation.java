package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ss_credit_card_information")
public class CreditCardInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String cardHolderName;
    private String cardNumber;
    private String expire;
    private Integer cvc;

    public CreditCardInformation() {
    }

    public CreditCardInformation(Long id, String email, String cardHolderName, String cardNumber, String expire, Integer cvc) {
        this.id = id;
        this.email = email;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expire = expire;
        this.cvc = cvc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    @Override
    public String toString() {
        return "CreditCardInformation{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expire='" + expire + '\'' +
                ", cvc=" + cvc +
                '}';
    }
}
