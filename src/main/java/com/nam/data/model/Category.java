package com.nam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", nullable = false)
    private long categoryId;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Category() {
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long ingredientId) {
        this.categoryId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
