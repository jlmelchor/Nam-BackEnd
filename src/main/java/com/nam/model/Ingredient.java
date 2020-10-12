package com.nam.model;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID", nullable = false)
    private long ingredientId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VEGAN", nullable = false)
    private String vegan;

    @Column(name = "VEGETARIAN", nullable = false)
    private String vegetarian;

    @Column(name = "GLUTEN_FREE", nullable = false)
    private String glutenFree;

    public Ingredient() {
    }

    public Ingredient(long ingredientId, String name, String vegan, String vegetarian, String glutenFree) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.glutenFree = glutenFree;
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

    public String getVegan() {
        return vegan;
    }

    public void setVegan(String vegan) {
        this.vegan = vegan;
    }

    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(String glutenFree) {
        this.glutenFree = glutenFree;
    }
}
