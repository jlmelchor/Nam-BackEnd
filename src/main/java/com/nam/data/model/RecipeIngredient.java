package com.nam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE_INGREDIENT")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_INGREDIENT_ID", nullable = false)
    private long recipeIngredientId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECIPE_ID", referencedColumnName = "RECIPE_ID")
    private Recipe recipe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "INGREDIENT_ID")
    private Ingredient ingredient;

    public RecipeIngredient() {
    }

    public long getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(long recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
