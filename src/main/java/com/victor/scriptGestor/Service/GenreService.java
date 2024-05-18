package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.GenreEntity;

import com.victor.scriptGestor.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;
    public List<GenreEntity> getAllGenres() {
        return genreRepository.findAll();
    }
    public Optional<GenreEntity> getGenreById(Integer id) {
        return genreRepository.findById(id);
    }
    public List<GenreEntity> getPoseByName (String name){
        return genreRepository.findByGenreName(name);
    }
    public GenreEntity saveGenre (GenreEntity genreEntity){
        return genreRepository.save(genreEntity);
    }
    public void deleteGenre (int id){
        genreRepository.deleteById(id);
    }

}
