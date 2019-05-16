package com.objis.formationboot.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jimmy on 16/05/2019.
 */
@Entity
public class Formationboot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String theme;
    private String description;

    public Formationboot() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
