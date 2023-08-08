package com.shopspace.shopspaceservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ss_type_classification")
public class TypeClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer status;
    @ManyToOne()
    @JoinColumn(name = "classification_categories_id")
    private ClassificationCategories classificationCategories;

    public TypeClassification() {
    }

    public TypeClassification(Long id, String name, Integer status, ClassificationCategories classificationCategories) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.classificationCategories = classificationCategories;
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

    public ClassificationCategories getClassificationCategories() {
        return classificationCategories;
    }

    public void setClassificationCategories(ClassificationCategories classificationCategories) {
        this.classificationCategories = classificationCategories;
    }

    @Override
    public String toString() {
        return "TypeClassification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", classificationCategories=" + classificationCategories +
                '}';
    }
}
