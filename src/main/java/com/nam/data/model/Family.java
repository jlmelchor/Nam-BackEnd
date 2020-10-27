package com.nam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "FAMILY")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAMILY_ID", nullable = false)
    private long ingredientId;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Family() {
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
