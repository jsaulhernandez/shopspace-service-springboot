package com.shopspace.shopspaceservice.model;

import com.shopspace.shopspaceservice.converter.DateConverter;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ss_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer off;
    @Convert(converter = DateConverter.class)
    private Date createdAt;
    @Convert(converter = DateConverter.class)
    private Date expireAt;
    private Integer status;

    public Coupon() {
    }

    public Coupon(Long id, String code, Integer off, Date createdAt, Date expireAt, Integer status) {
        this.id = id;
        this.code = code;
        this.off = off;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOff() {
        return off;
    }

    public void setOff(Integer off) {
        this.off = off;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", off=" + off +
                ", createdAt=" + createdAt +
                ", expireAt=" + expireAt +
                ", status=" + status +
                '}';
    }
}
