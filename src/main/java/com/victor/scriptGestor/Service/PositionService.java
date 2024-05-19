package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.PositionEntity;
import com.victor.scriptGestor.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    @Autowired
    private PositionRepository repository;
    @Autowired
    private  PoseService poseService;
    public List<PositionEntity> getAll() {
        return repository.findAll();
    }
    public Optional<PositionEntity> getById(Integer id) {
        return repository.findById(id);
    }

    public PositionEntity save(PositionEntity entity){
        return this.repository.save(entity);
    }
    public void delete(int id){
        repository.deleteById(id);
    }

    public List<PositionEntity> getByPoseid (int poseId){
        return repository.findByidPose(poseId);
    }




}

