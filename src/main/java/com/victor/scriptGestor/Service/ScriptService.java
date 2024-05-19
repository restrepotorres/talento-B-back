package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.PositionEntity;
import com.victor.scriptGestor.Entity.ScriptEntity;
import com.victor.scriptGestor.Repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScriptService {
    @Autowired
    private ScriptRepository repository;

    public List<ScriptEntity> getAll() {
        return repository.findAll();
    }
    public Optional<ScriptEntity> getById(Integer id) {
        return repository.findById(id);
    }

    public ScriptEntity save(ScriptEntity entity){
        return this.repository.save(entity);
    }
    public void delete(int id){
        repository.deleteById(id);
    }

    public List<ScriptEntity> getByGenreid (int genreId){
        return repository.findByidGenre(genreId);
    }

}
