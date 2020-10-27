package com.nam.data.repository;

import com.nam.data.model.NamUser;
import com.nam.data.model.Recipe;
import com.nam.data.model.RecipeFav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeFavRepository extends JpaRepository<RecipeFav, Long> {

    List<RecipeFav> findByNamUser(NamUser NamUser);

    RecipeFav findByNamUserAndRecipe(NamUser namUser, Recipe recipe);

}
