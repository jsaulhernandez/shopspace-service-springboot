package com.shopspace.shopspaceservice.model;

import com.shopspace.shopspaceservice.converter.DateConverter;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ss_user_customer")
public class UserCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private Integer status;
    @Convert(converter = DateConverter.class)
    private Date createdAt;
    @Convert(converter = DateConverter.class)
    private Date updatedAt;
    private Integer verifiedEmail;
    @OneToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public UserCustomer() {
    }

    public UserCustomer(Long id, String userName, String password, Integer status, Date createdAt, Date updatedAt, Integer verifiedEmail, Customer customer) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.verifiedEmail = verifiedEmail;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(Integer verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "UserCustomer{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", verifiedEmail=" + verifiedEmail +
                ", customer=" + customer +
                '}';
    }
}
