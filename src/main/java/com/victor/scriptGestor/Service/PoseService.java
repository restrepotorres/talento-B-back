package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.PoseEntity;
import com.victor.scriptGestor.Repository.PoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoseService {
    @Autowired
    private PoseRepository repository;

    public List<PoseEntity> getAll() {
        return repository.findAll();
    }
    public Optional<PoseEntity> getById(Integer id) {
        return repository.findById(id);
    }
    public List<PoseEntity> getPoseByName (String name){
        return repository.findByposeName(name);
    }
    public PoseEntity save(PoseEntity entity){
        return this.repository.save(entity);
    }
    public void delete(int id){
        repository.deleteById(id);
    }


}
