package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ss_classification_categories")
public class ClassificationCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer status;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Categories categories;

    public ClassificationCategories() {
    }

    public ClassificationCategories(Long id, String name, Integer status, Categories categories) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.categories = categories;
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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ClassificationCategories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", categories=" + categories +
                '}';
    }
}
