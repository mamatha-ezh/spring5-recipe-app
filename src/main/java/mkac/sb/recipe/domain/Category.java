/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkac.sb.recipe.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author mamat
 */
@Entity
public class Category {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    
    @ManyToMany(mappedBy="categories")
    private Set<Recipe> recipes;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
