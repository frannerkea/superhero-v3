package com.example.superherov3.Services;

import com.example.superherov3.Model.SuperheroModel;
import com.example.superherov3.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheroService {

    private SuperheroRepository superheroRepository;

    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    public List<SuperheroModel> getAllSuperHeros() {
        return superheroRepository.getAllSuperHeros();
    }

    public List<SuperheroModel> getSuperHero(String name) {
        ArrayList<SuperheroModel> allSuperHeros = (ArrayList<SuperheroModel>) this.getAllSuperHeros();
        ArrayList<SuperheroModel> superHeroes = new ArrayList<>();
        for (SuperheroModel superheroModel : allSuperHeros) {
            if (superheroModel.getName().toLowerCase().contains(name.toLowerCase())) {
                superHeroes.add(superheroModel);
            }
        }
        return superHeroes;
    }

    public SuperheroModel createSuperhero(SuperheroModel superheroModel) {
        superheroRepository.addSuperhero(superheroModel);
        return superheroModel;

    }

    public List<SuperheroModel> editSuperhero(String id) {
        String[] data = id.split(",");
        try {
            SuperheroModel superheroToEdit = new SuperheroModel(data[0], data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]));
            ArrayList<SuperheroModel> superheroes = (ArrayList<SuperheroModel>) getAllSuperHeros();
            boolean superheroFound = false;
            for (SuperheroModel superheroModel: superheroes) {
                if (superheroModel.getName().equalsIgnoreCase(superheroToEdit.getName())) {
                    superheroFound = true;
                    superheroes.remove(superheroModel);
                    break;
                }
            }
            if (superheroFound) {
                superheroRepository.addSuperhero(superheroToEdit);
            }
            return new ArrayList<>(List.of(superheroToEdit));
        } catch (Exception exception) {
            System.out.println(exception);
            return new ArrayList<>();
        }
    }


}
