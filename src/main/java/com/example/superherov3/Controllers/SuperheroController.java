package com.example.superherov3.Controllers;

import com.example.superherov3.DTO.HeroCityDTO;
import com.example.superherov3.DTO.HeroPowerCountDTO;
import com.example.superherov3.DTO.HeroPowerDTO;
import com.example.superherov3.Model.SuperheroModel;
import com.example.superherov3.Services.SuperheroService;
import com.example.superherov3.repositories.SuperheroRepository;
import com.example.superherov3.repositories.SuperheroRepository_DB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SuperheroController {

    private SuperheroService superheroService;
    private SuperheroRepository_DB superheroRepository_db;



    public SuperheroController(SuperheroService superheroService, SuperheroRepository_DB superheroRepository_db) {
        this.superheroService = superheroService;
        this.superheroRepository_db = superheroRepository_db;
    }



    @GetMapping("/{name}")
    public ResponseEntity <SuperheroModel> getSuperHero(@PathVariable String name) {
        return new ResponseEntity<>(superheroRepository_db.printSuperHero(name), HttpStatus.OK);
    }


    @GetMapping("/superpower/count/")
    public ResponseEntity<List<HeroPowerCountDTO>> printHeroCount() {
        return new ResponseEntity<>(superheroRepository_db.printHeroPowerCount(), HttpStatus.OK);
    }


    // /superpower/{navn}
    @GetMapping("/superpower")
    public ResponseEntity<List<HeroPowerDTO>> printHeroPowers() {
        return new ResponseEntity<>(superheroRepository_db.printHeroPowers(), HttpStatus.OK);
    }

    //  /city/{navn}

    @GetMapping("/city")
    public ResponseEntity<List<HeroCityDTO>> printHeroCity() {
        return new ResponseEntity<>(superheroRepository_db.printHeroCity(), HttpStatus.OK);
    }


    /*
     @GetMapping("/liste")
    public String getAllSuperHeros() {
        return superheroService.getAllSuperHeros().toString();
    }

    @PostMapping("/opret")
    public ResponseEntity<SuperheroModel> createSuperhero(@RequestBody SuperheroModel superheroModel) {
        SuperheroModel temp = superheroService.createSuperhero(superheroModel);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/ret")
    public ResponseEntity<List<SuperheroModel>> editSuperhero(@RequestParam String id) {
        return new ResponseEntity<>(superheroService.editSuperhero(id), HttpStatus.OK);
    }

     */

    /*
    @GetMapping("/")
    public ResponseEntity<List<SuperheroModel>> getAllSuperHeros() {
        return new ResponseEntity<>(superheroService.getAllSuperHeros(), HttpStatus.OK);
    }
     */

}
