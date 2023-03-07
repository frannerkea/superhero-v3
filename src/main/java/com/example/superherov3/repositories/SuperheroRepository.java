package com.example.superherov3.repositories;

import com.example.superherov3.Model.SuperheroModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class SuperheroRepository {
    private ArrayList<SuperheroModel> superheroes = new ArrayList<>();




    //String name, String superPower, String humanForm, int yearIntroduced, double strength)
    private SuperheroModel superman = new SuperheroModel("superman", "laser eyes", "no", 1960, 9999);
    private SuperheroModel batman = new SuperheroModel("batman", "ich", "yes", 1960, 7000);
    private boolean changesMade = false;

    public SuperheroRepository() {
        superheroes.add(superman);
        superheroes.add(batman);
    }

    public ArrayList<SuperheroModel> getAllSuperHeros() {
        return superheroes;
    }

    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        this.superheroes.add(new SuperheroModel(name, superpower, form, yearIntroduced, strength));;
        setChangesMade();
    }
    public void addSuperhero(SuperheroModel superheroModel) {
        this.superheroes.add(superheroModel);
    }

    public void setChangesMade() {
        this.changesMade = true;
    }

}

