package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ss_color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    private Integer status;

    public Color() {
    }

    public Color(Long id, String value, Integer status) {
        this.id = id;
        this.value = value;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", status=" + status +
                '}';
    }
}
