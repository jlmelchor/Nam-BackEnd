package com.nam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE_FAV")
public class RecipeFav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_FAV_ID", nullable = false)
    private long recipeFavId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private NamUser namUser;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "RECIPE_ID", referencedColumnName = "RECIPE_ID")
    private Recipe recipe;

    public RecipeFav() {
    }

    public long getRecipeFavId() {
        return recipeFavId;
    }

    public void setRecipeFavId(long recipeFavId) {
        this.recipeFavId = recipeFavId;
    }

    public NamUser getUser() {
        return namUser;
    }

    public void setUser(NamUser namUser) {
        this.namUser = namUser;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
