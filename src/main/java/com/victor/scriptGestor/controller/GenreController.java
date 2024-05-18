package com.victor.scriptGestor.controller;

import com.victor.scriptGestor.Entity.GenreEntity;
import com.victor.scriptGestor.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService genreService;
    @GetMapping
    @RequestMapping("/health-check")
    public String helloworld(){
        return "OK";
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<GenreEntity> getById(@PathVariable Integer id) {
        return genreService.getGenreById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getbyname")
    public List<GenreEntity> getByName(@RequestParam String genrename) {
        return genreService.getPoseByName(genrename);
    }

    @GetMapping("/getall")
    public List<GenreEntity> getAllEmployees() {
        return genreService.getAllGenres();
    }
    @PostMapping("/save")
    public GenreEntity createGenre (@RequestBody GenreEntity genreEntity){
        return genreService.saveGenre(genreEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePose (@PathVariable Integer id){
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
