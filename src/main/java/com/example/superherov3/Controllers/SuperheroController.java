package com.example.superherov3.Controllers;

import com.example.superherov3.Model.SuperheroModel;
import com.example.superherov3.Services.SuperheroService;
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

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService =  superheroService;
    }



    @GetMapping("/liste")
    public String getAllSuperHeros() {
        return superheroService.getAllSuperHeros().toString();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SuperheroModel>> getSuperHero(@PathVariable String id) {
        return new ResponseEntity<>(superheroService.getSuperHero(id), HttpStatus.OK);
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

    /*
    @GetMapping("/")
    public ResponseEntity<List<SuperheroModel>> getAllSuperHeros() {
        return new ResponseEntity<>(superheroService.getAllSuperHeros(), HttpStatus.OK);
    }
     */

}
